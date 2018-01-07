package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.service.ActivityService;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/ajax/mkt/leads")
@Validated
public class AjaxLeadsController extends AjaxBaseLeadsController {

    @Autowired
    private ActivityService actServ;

    @AjaxControllerLog
    @RequiresPermissions("1-2")
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list(@NotEmpty String orgId) throws AjaxException {

        return this.list(orgId, 1);
    }

    @AjaxControllerLog
    @RequiresPermissions("1-2")
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @Override
    public Object query(String id) {

        return super.query(id);
    }

    @AjaxControllerLog
    @RequiresPermissions("1-2-1")
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @Override
    public Object add(TLeads leads, TLeadsStudent student, TLeadsParent parent) throws AjaxException {

        leads.setTypeId(1);
        super.add(leads, student, parent);
        actServ.updateLeadsCountsById(leads.getChannelId());

        return leads.getId();
    }

    @AjaxControllerLog
    @RequiresPermissions("1-2-2")
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    @Override
    public Object mod(TLeads leads, TLeadsStudent student, TLeadsParent parent) throws AjaxException {

        TLeads target = leadsServ.queryLeadsById(leads.getId());
        if (target == null) {
            throw new AjaxException(412, "Failed to find leads");
        }

        super.mod(leads, student, parent);

        if (leads.getChannelId() != target.getChannelId()) {
            actServ.updateLeadsCountsById(target.getChannelId());
            actServ.updateLeadsCountsById(leads.getChannelId());
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("1-2-3")
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    @Override
    public Object del(String id) throws AjaxException {

        TLeads target = leadsServ.queryLeadsById(id);
        if (target == null) {
            throw new AjaxException(412, "Failed to find leads");
        }

        super.del(id);
        actServ.updateLeadsCountsById(target.getChannelId());

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("1-2-5")
    @RequestMapping(value = "assign.do", method = RequestMethod.POST)
    @Override
    public Object assign(String id, String assigneeId) throws AjaxException {

        return super.assign(id, assigneeId);
    }

    @AjaxControllerLog
    @RequiresPermissions("1-2-6")
    @RequestMapping(value = "convert.do", method = RequestMethod.POST)
    public Object convert(@NotEmpty String id, @NotEmpty String assigneeId) throws AjaxException {

        if (!leadsServ.convertToOpportunityById(id)) {
            throw new AjaxException(500, "Failed to convert leads");
        }
        if (!leadsServ.assignToExecutiveById(id, assigneeId)) {
            throw new AjaxException(501, "Failed to assign leads");
        }

        return true;
    }

}
