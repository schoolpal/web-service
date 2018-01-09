package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/ajax/org")
@Validated
public class AjaxOrgController extends AjaxBaseController{

    @Autowired
    private UserService userServ;
    @Autowired
    private OrgService orgServ;
    @Autowired
    private RoleService roleServ;

    @AjaxControllerLog
    @RequestMapping(value = "listRoles.do", method = RequestMethod.POST)
    public Object listRoles(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
        if (!orgList.contains(id)) {
            throw new AjaxException(401, "No permission to query organization");
        }

        List<TRole> roles = roleServ.queryRoleListByOrgIdLite(id);
        if (roles == null) {
            throw new AjaxException(500, "Cannot find organization");
        }

        return roles;
    }

    @AjaxControllerLog
    @RequestMapping(value = "listUsers.do", method = RequestMethod.POST)
    public Object listUsers(@NotEmpty String id) throws AjaxException {
        TUser user = userServ.getCachedUser();

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), id)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        List<TUser> users = userServ.queryUsersByOrgId(id);
        if (users == null) {
            throw new AjaxException(500, "Cannot find organization");
        }

        return users;
    }

    @AjaxControllerLog
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    public Object query(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
        if (!orgList.contains(id)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        TOrg org = orgServ.queryOrgById(id);
        if (org == null) {
            throw new AjaxException(500, "Cannot find organization");
        }
        org.setParentOrg(orgServ.queryOrgById(org.getcParentId()));

        return org;
    }


}
