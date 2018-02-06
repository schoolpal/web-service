package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ajax/sales/oppor")
public class AjaxSalesOpporController extends AjaxBaseLeadsController {

    @AjaxControllerLog
    @RequiresPermissions("2-1")
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list(String orgId) throws AjaxException {
        return super.list(2, orgId);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-1")
    @RequestMapping(value = "listAssignableUsers.do", method = RequestMethod.POST)
    public Object listAssignableUsers(@NotEmpty String orgId) throws AjaxException {
        TUser user = userServ.getCachedUser();

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), orgId)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        List<TUser> users = new ArrayList<>();
        switch (user.getHighestRank()){
            case 1:
                users = super.listAssignableUsersByOrgId(orgId, u -> (u.hasSalesPermission()));
                break;
            case 2:
                users = super.listAssignableUsersByOrgId(orgId,
                        u -> (u.getcId().equals(user.getcId()) || (u.hasSalesPermission() && u.getHighestRank() == 3)));
                break;
            case 3:
                users.add(user);
                break;
            default:
                break;
        }

        return users;
    }

    @AjaxControllerLog
    @RequiresPermissions("2-1")
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @Override
    public Object query(String id) throws AjaxException {

        return super.query(id);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-1-1")
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @Transactional
    @Override
    public Object add(@Validated({AjaxControllerAdd.class}) TLeads leads,
                      @Validated({AjaxControllerAdd.class}) TLeadsStudent student,
                      @Validated({AjaxControllerAdd.class}) TLeadsParent parent) throws AjaxException {

        if (leads.getTypeId() != 2 && leads.getTypeId() != 3) {
            throw new AjaxException(411, "Type id cannot be empty");
        }

        return super.add(leads, student, parent);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-1-2")
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    @Transactional
    @Override
    public Object mod(@Validated({AjaxControllerMod.class}) TLeads leads,
                      @Validated({AjaxControllerMod.class}) TLeadsStudent student,
                      @Validated({AjaxControllerMod.class}) TLeadsParent parent) throws AjaxException {

        return super.mod(leads, student, parent);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-1-3")
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    @Transactional
    @Override
    public Object del(String id) throws AjaxException {

        return super.del(id);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-1-5")
    @RequestMapping(value = "assign.do", method = RequestMethod.POST)
    @Override
    public Object assign(String id, String assigneeId) throws AjaxException {

        return super.assign(id, assigneeId);
    }

}
