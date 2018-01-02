package com.schoolpal.ajax.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.schoolpal.validator.Passwords;
import com.schoolpal.web.model.PasswordsForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.ajax.model.AjaxResponse;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;
import com.schoolpal.web.consts.*;
import com.schoolpal.web.model.LoginForm;

@RestController
@RequestMapping("/ajax/user")
public class AjaxUserController {

    @Autowired
    private UserService userServ;
    @Autowired
    private OrgService orgServ;

    private Gson gson = new Gson();

    @RequestMapping(value = "salt.do", method = RequestMethod.POST)
    public AjaxResponse salt() {
        AjaxResponse res = new AjaxResponse(200);

        // Generate a number between 1000 and 9999.
        Random random = new Random();
        String salt = Integer.toString(random.nextInt(9000) + 1000);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession(true);
        session.setAttribute(Const.SESSION_KEY_LOGIN_SALT, salt);
        res.setData(salt);

        return res;
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public AjaxResponse login(@Valid LoginForm login) {

        AjaxResponse res = new AjaxResponse();
        if (userServ.login(login.getLoginName(), login.getMixedPWD())) {
            try {
                userServ.cacheUser(login.getLoginName());
            } catch (Exception ex) {
                Subject currentUser = SecurityUtils.getSubject();
                currentUser.logout();

                res.setCode(500);
                res.setDetail("Failed to login, unexpect error");
            }
        } else {
            res.setCode(401);
            res.setDetail("Failed to login, wrong user/pass");
        }

        return res;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    public AjaxResponse logout() {
        Subject currentUser = SecurityUtils.getSubject();
        AjaxResponse res = new AjaxResponse();
        if (null != currentUser && null != currentUser.getPrincipal()) {
            String username = userServ.getCachedUser().getcLoginname();

            currentUser.logout();
            userServ.clearUserCache(username);
        } else {
            res.setCode(500);
            res.setDetail("Illegal access");
        }

        return res;
    }

    @RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
    public AjaxResponse changePassword(@Valid PasswordsForm form, HttpServletRequest request) {
        AjaxResponse res = new AjaxResponse();
        do {

            Subject currentUser = SecurityUtils.getSubject();

            TUser user = userServ.getCachedUser(currentUser);
            if (!form.getOriPass().equals(userServ.queryLoginPassByName(user.getcLoginname()))) {
                res.setCode(405);
                res.setDetail("Wrong original password");
                break;
            }

            boolean result = userServ.changeLoginPassById(user.getcId(), form.getOriPass(), form.getNewPass());
            res.setData(result);
        } while (false);

        return res;
    }

    @RequestMapping(value = "status.do", method = RequestMethod.POST)
    public AjaxResponse status() {
        AjaxResponse res = new AjaxResponse();
        return res;
    }

    @RequestMapping(value = "profile.do", method = RequestMethod.POST)
    public AjaxResponse profile() {
        AjaxResponse res = new AjaxResponse();

        TUser user = userServ.getCachedUser();
        res.setData(user);

        return res;
    }

    @RequestMapping(value = "listOrgs.do", method = RequestMethod.POST)
    public AjaxResponse listOrgs() {
        AjaxResponse res = new AjaxResponse();

        TUser user = userServ.getCachedUser();
        List<TOrg> orgList = orgServ.queryOrgListByRootIdLite(user.getcOrgId());
        res.setData(orgList);

        return res;
    }

    @RequestMapping(value = "listRoles.do", method = RequestMethod.POST)
    public AjaxResponse listRoles() {
        AjaxResponse res = new AjaxResponse();

        TUser user = userServ.getCachedUser();
        List<TRole> roleList = user.getRoles();
        res.setData(roleList);

        return res;
    }

    @RequestMapping(value = "listFuncs.do", method = RequestMethod.POST)
    public AjaxResponse listFuncs() {

        AjaxResponse res = new AjaxResponse(200);

        List<TFunction> funcList = new ArrayList<TFunction>();
        TUser user = userServ.getCachedUser();
        for (TRole r : user.getRoles()) {
            funcList.addAll(r.getFunctions());
        }
        res.setData(funcList);

        return res;
    }

    @RequestMapping(value = "listFuncsByRole.do", method = RequestMethod.POST)
    public AjaxResponse listFuncsByRole(String id) {
        AjaxResponse res = new AjaxResponse(200);

        do {
            TUser user = userServ.getCachedUser();

            if (!user.getRoleIds().contains(id)) {
                res.setCode(401);
                res.setDetail("User don't have this role");
                break;
            }

            List<TFunction> funcList = user.getRoleById(id).getFunctions();
            res.setData(funcList);

        } while (false);

        return res;
    }

}
