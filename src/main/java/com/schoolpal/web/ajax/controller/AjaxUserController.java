package com.schoolpal.web.ajax.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.schoolpal.web.ajax.exception.AjaxException;
import com.schoolpal.web.model.PasswordsForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.schoolpal.db.model.*;
import com.schoolpal.service.*;
import com.schoolpal.consts.*;
import com.schoolpal.web.model.LoginForm;

@RestController()
@RequestMapping("/ajax/user")
public class AjaxUserController {

    @Autowired
    private UserService userServ;
    @Autowired
    private OrgService orgServ;

    private Logger logger = LoggerFactory.getLogger(getClass());

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

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public Object login(@Valid LoginForm login) throws AjaxException {

        if (userServ.login(login.getLoginName(), login.getMixedPWD())) {
            try {
                userServ.cacheUser(login.getLoginName());
            } catch (Exception ex) {
                Subject currentUser = SecurityUtils.getSubject();
                currentUser.logout();

                throw new AjaxException(500, "Failed to login, unexpect error", ex);
            }
        } else {

            throw new AjaxException(401, "Failed to login, wrong user/pass");
        }

        return null;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    public Object logout() throws AjaxException {

        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser && null != currentUser.getPrincipal()) {
            String username = userServ.getCachedUser().getcLoginname();

            currentUser.logout();
            userServ.clearUserCache(username);
        } else {
            throw new AjaxException(500, "Illegal access");
        }

        return null;
    }

    @RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
    public Object changePassword(@Valid PasswordsForm form, HttpServletRequest request) throws AjaxException {
        boolean result = false;

        Subject currentUser = SecurityUtils.getSubject();
        TUser user = userServ.getCachedUser(currentUser);
        if (!form.getOriPass().equals(userServ.queryLoginPassByName(user.getcLoginname()))) {
            throw new AjaxException(405, "Wrong original password");
        }
        result = userServ.changeLoginPassById(user.getcId(), form.getOriPass(), form.getNewPass());

        return result;
    }

    @RequestMapping(value = "status.do", method = RequestMethod.POST)
    public Object status() {
        return null;
    }

    @RequestMapping(value = "profile.do", method = RequestMethod.POST)
    public Object profile() {
        TUser user = userServ.getCachedUser();
        return user;
    }

    @RequestMapping(value = "listOrgs.do", method = RequestMethod.POST)
    public Object listOrgs() {
        TUser user = userServ.getCachedUser();
        List<TOrg> orgList = orgServ.queryOrgListByRootIdLite(user.getcOrgId());

        return orgList;
    }

    @RequestMapping(value = "listRoles.do", method = RequestMethod.POST)
    public Object listRoles() {
        TUser user = userServ.getCachedUser();
        List<TRole> roleList = user.getRoles();

        return roleList;
    }

    @RequestMapping(value = "listFuncs.do", method = RequestMethod.POST)
    public Object listFuncs() {

        List<TFunction> funcList = new ArrayList<TFunction>();
        TUser user = userServ.getCachedUser();
        for (TRole r : user.getRoles()) {
            funcList.addAll(r.getFunctions());
        }

        return funcList;
    }

    @RequestMapping(value = "listFuncsByRole.do", method = RequestMethod.POST)
    public Object listFuncsByRole(String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        if (!user.getRoleIds().contains(id)) {
            throw new AjaxException(401, "User don't have this role");
        }

        List<TFunction> funcList = user.getRoleById(id).getFunctions();

        return funcList;
    }

}
