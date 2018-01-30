package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.consts.Const;
import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.ajax.exception.AjaxException;
import com.schoolpal.web.model.LoginForm;
import com.schoolpal.web.model.PasswordsForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/ajax/user")
@Validated
public class AjaxUserController extends AjaxBaseController {

    @Autowired
    private UserService userServ;
    @Autowired
    private OrgService orgServ;

    //    @AjaxControllerLog
    @RequestMapping(value = "salt.do", method = RequestMethod.POST, produces = "application/json")
    public Object salt() {

        // Generate a number between 1000 and 9999.
        Random random = new Random();
        String salt = Integer.toString(random.nextInt(9000) + 1000);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession(true);
        session.setAttribute(Const.SESSION_KEY_LOGIN_SALT, salt);

        return salt;
    }

    @AjaxControllerLog
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public Object login(@Valid LoginForm login) throws AjaxException {
        if (!userServ.login(login.getLoginName(), login.getMixedPWD())) {
            throw new AjaxException(401, "Failed to login, wrong user/pass");
        }
        return null;
    }

    @AjaxControllerLog
    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    public Object logout() throws AjaxException {
        userServ.logout();
        return null;
    }

    @AjaxControllerLog
    @RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
    public Object changePassword(@Valid PasswordsForm form) throws AjaxException {
        boolean result = false;

        Subject currentUser = SecurityUtils.getSubject();
        TUser user = userServ.getCachedUser(currentUser);
        if (!form.getOriPass().equals(userServ.queryLoginPassByName(user.getcLoginName()))) {
            throw new AjaxException(405, "Wrong original password");
        }

        try {
            userServ.changeLoginPassById(user.getcId(), form.getOriPass(), form.getNewPass());
            result = true;
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to change password");
        }

        return result;
    }

    @AjaxControllerLog
    @RequestMapping(value = "status.do", method = RequestMethod.POST)
    public Object status() {
        return null;
    }

    //    @AjaxControllerLog
    @RequestMapping(value = "profile.do", method = RequestMethod.POST)
    public Object profile() {
        TUser user = userServ.getCachedUser();
        return user;
    }

    //    @AjaxControllerLog
    @RequestMapping(value = "listOrgs.do", method = RequestMethod.POST)
    public Object listOrgs() {
        TUser user = userServ.getCachedUser();
        List<TOrg> orgList = orgServ.queryOrgListByRootIdLite(user.getcOrgId());

        return orgList;
    }

    //    @AjaxControllerLog
    @RequestMapping(value = "listRoles.do", method = RequestMethod.POST)
    public Object listRoles() {
        TUser user = userServ.getCachedUser();
        List<TRole> roleList = user.getRoles();

        return roleList;
    }

    //    @AjaxControllerLog
    @RequestMapping(value = "listFuncs.do", method = RequestMethod.POST)
    public Object listFuncs() {

        List<TFunction> funcList = new ArrayList<TFunction>();
        TUser user = userServ.getCachedUser();
        for (TRole r : user.getRoles()) {
            funcList.addAll(r.getFunctions());
        }

        return funcList;
    }

    //    @AjaxControllerLog
    @RequestMapping(value = "listFuncsByRole.do", method = RequestMethod.POST)
    public Object listFuncsByRole(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        if (!user.getRoleIds().contains(id)) {
            throw new AjaxException(402, "User don't have this role");
        }

        List<TFunction> funcList = user.getRoleById(id).getFunctions();

        return funcList;
    }

}
