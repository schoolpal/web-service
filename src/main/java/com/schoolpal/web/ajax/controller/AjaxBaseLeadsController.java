package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public abstract class AjaxBaseLeadsController extends AjaxBaseController {

    @Autowired
    protected UserService userServ;
    @Autowired
    protected LeadsService leadsServ;

    public Object list(@NotEmpty String orgId, @NotNull Integer typeId) {

        List<TLeads> leadsList = leadsServ.queryLeadsListByOrgId(orgId, typeId);

        return leadsList;
    }

    public Object query(@NotEmpty String id) {

        TLeads leads = leadsServ.queryLeadsById(id);

        return leads;
    }

    public Object add(TLeads leads, TLeadsStudent student, TLeadsParent parent) throws AjaxException {

        TUser user = userServ.getCachedUser();
        try {
            leadsServ.add(leads, student, parent, user.getcId());
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to add leads", e);
        }

        return leads.getId();
    }

    public Object mod(TLeads leads, TLeadsStudent student, TLeadsParent parent) throws AjaxException {

        leads.setTypeId(null);
        try {
            leadsServ.mod(leads, student, parent);
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to mod leads", e);
        }

        return true;
    }

    public Object del(@NotEmpty String id) throws AjaxException {

        try {
            leadsServ.delById(id);
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to del leads");
        }

        return true;
    }

    public Object assign(@NotEmpty String id, @NotEmpty String assigneeId) throws AjaxException {

        try {
            leadsServ.assignToExecutiveById(id, assigneeId);
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to assign leads");
        }

        return true;
    }

}
