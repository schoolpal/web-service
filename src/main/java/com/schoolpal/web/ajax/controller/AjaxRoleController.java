package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TRank;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/ajax/role")
public class AjaxRoleController extends AjaxBaseController{

    @Autowired
    private UserService userServ;
    @Autowired
    private OrgService orgServ;
    @Autowired
    private RoleService roleServ;

    @AjaxControllerLog
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    public Object query(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());

        TRole role = roleServ.queryRoleById(id);
        if (role == null) {
            throw new AjaxException(400, "Cannot find role");
        }
        if (!orgList.contains(role.getcOrgId())) {
            throw new AjaxException(401, "No permission to query role under parent organization");
        }

        return role;
    }

    @AjaxControllerLog
    @RequestMapping(value = "ranks.do", method = RequestMethod.POST)
    public Object ranks() throws AjaxException {
        List<TRank> rankList = roleServ.queryRankList();

        return rankList;
    }

}
