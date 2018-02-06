package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Validated
public abstract class AjaxBaseLeadsController extends AjaxBaseController {

    @Autowired
    protected UserService userServ;
    @Autowired
    protected LeadsService leadsServ;
    @Autowired
    protected OrgService orgServ;

    public Object list(@NotNull Integer typeId, @NotEmpty String orgId) throws AjaxException {

        TUser user = userServ.getCachedUser();
        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), orgId)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        List<TLeads> ret = new ArrayList<>();

        List<String> orgList = orgServ.queryOrgIdListByRootId(orgId);
        if (orgList != null) {
            orgList.forEach(o -> {
                if (o.equals(user.getcOrgId())) {
                    if (user.getHighestRank() == 1) {
                        ret.addAll(leadsServ.queryLeadsListByOrgId(typeId, orgId));
                    } else if (user.getHighestRank() == 3) {
                        ret.addAll(leadsServ.queryLeadsListByExecutived(typeId, user.getcId()));
                    } else if (user.getHighestRank() == 2) {
                        ret.addAll(leadsServ.queryLeadsListByExecutived(typeId, user.getcId()));
                        ret.addAll(leadsServ.queryLeadsListByOrgIdForRank2(typeId, orgId));
                    } else {
                        //Unexpected user rank, no leads should be returned
                        return;
                    }
                } else {
                    ret.addAll(leadsServ.queryLeadsListByOrgId(typeId, o));
                }
            });
        }

        ret.sort(Comparator.comparing(TLeads::getId).reversed());

        return ret;
    }

    public Object listByOrgId(@NotNull Integer typeId, @NotEmpty String orgId) throws AjaxException {

        TUser user = userServ.getCachedUser();
        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), orgId)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        List<TLeads> leadsList = leadsServ.queryLeadsListByOrgId(typeId, orgId);

        return leadsList;
    }

    public Object listByExecutiveId(@NotNull Integer typeId, @NotEmpty String executiveId) {

        List<TLeads> leadsList = leadsServ.queryLeadsListByExecutived(typeId, executiveId);

        return leadsList;
    }

    public List<TUser> listAssignableUsersByOrgId(@NotEmpty String orgId, Predicate<TUser> userFilter) throws AjaxException {

        List<TUser> users = userServ.queryUsersByOrgId(orgId);
        if (users != null) {
            users = users.stream().filter(userFilter).sorted(Comparator.comparing(TUser::getcId)).collect(Collectors.toList());
        }

        return users;
    }

    public Object query(@NotEmpty String id) throws AjaxException {

        TLeads leads = leadsServ.queryLeadsById(id);
/*
        TUser user = userServ.getCachedUser();
        if (!orgServ.isOrgBelongToTargetOrg(leads.getOrganizationId(), user.getcOrgId())) {
            throw new AjaxException(402, "No permission to query organization");
        }

        if(user.getHighestRank() == 1){
            //No limit for rank 1
        }else if(user.getHighestRank() == 3){
            if(leads.getExecutiveId() != user.getcId()){
                throw new AjaxException(402, "No permission to query leads");
            }
        }else if(user.getHighestRank() == 2){
            if(leadsServ.queryLeadsByIdForRank2(id) == null){
                throw new AjaxException(403, "No permission to query leads");
            }
        }else {
            throw new AjaxException(404, "Unexpected user rank");
        }
*/
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

        TUser user = userServ.queryUserById(assigneeId);
        if (user == null) {
            throw new AjaxException(402, "User not exists");
        }
        if (user.hasSystemPermission()) {
            throw new AjaxException(403, "Cannot assign to system manager");
        }

        try {
            leadsServ.assignToExecutiveById(id, user.getcId(), user.getcOrgId());
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to assign leads");
        }

        return true;
    }

}
