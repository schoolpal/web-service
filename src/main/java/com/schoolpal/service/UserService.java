package com.schoolpal.service;

import com.google.gson.Gson;
import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.Const;
import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TUserMapper userDao;
    @Autowired
    private TUserRoleMapper userRoleDao;
    @Autowired
    private TOrgMapper orgDao;
    @Autowired
    private TRoleMapper roleDao;
    @Autowired
    private TRoleFunctionMapper roleFuncDao;

    private static Gson gson = new Gson();

    @ServiceLog
    public boolean login(String loginName, String mixedPWD) {
        boolean ret = false;

        do {
            if (StringUtils.isEmpty(loginName)) {
                break;
            }

            try {
                Subject currentUser = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(loginName, mixedPWD, false);
                currentUser.login(token);

                this.cacheUser(loginName);
            } catch (Exception e) {
                break;
            }

            this.userDao.updateLastVisitByLoginName(loginName, request.getRemoteAddr());

            ret = true;
        } while (false);

        return ret;
    }

    public void logout(){
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null && currentUser.getPrincipal() != null) {
            String username = this.getCachedUser().getcLoginName();
            currentUser.logout();
            this.clearUserCache(username);
        }
    }

    @ServiceLog
    public TUser cacheUser(String username) {

        TUser user = this.queryUserByLoginName(username);

        String jsonUser = gson.toJson(user);
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute(Const.SESSION_KEY_CURRENT_USER, jsonUser);

        return user;
    }

    public TUser getCachedUser() {

        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser == null || currentUser.getPrincipal() == null) {
            return null;
        }

        Session session = currentUser.getSession(true);
        return gson.fromJson((String) session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
    }

    public TUser getCachedUser(Subject currentUser) {
        Session session = currentUser.getSession(true);
        return gson.fromJson((String) session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
    }

    public void clearUserCache(String username) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.removeAttribute(Const.SESSION_KEY_CURRENT_USER);
    }

    public TUser queryUserById(String id) {
        TUser user = userDao.selectOneById(id);

        TOrg org = orgDao.selectOneById(user.getcOrgId());
        user.setOrg(org);

        List<TRole> roles = roleDao.selectRolesByUserId(user.getcId());
        for (TRole role : roles) {
            List<TFunction> funcs = roleFuncDao.selectAllFuncsByRoleId(role.getcId());
            role.setFunctions(funcs);
        }
        user.setRoles(roles);

        return user;
    }

    public boolean checkLoginNameExists(String loginName) {
        return userDao.ifExistsByName(loginName);
    }

    public String queryLoginPassByName(String loginName) {
        return userDao.selectPasswordByLoginName(loginName);
    }

    public void changeLoginPassById(String id, String oriPass, String newPass) {
        userDao.updateLoginPassById(id, oriPass, newPass);
    }

    private TUser queryUserByLoginName(String loginName) {
        TUser user = userDao.selectOneByLoginName(loginName);

        TOrg org = orgDao.selectOneById(user.getcOrgId());
        user.setOrg(org);

        List<TRole> roles = roleDao.selectRolesByUserId(user.getcId());
        for (TRole role : roles) {
            List<TFunction> funcs = roleFuncDao.selectAllFuncsByRoleId(role.getcId());
            role.setFunctions(funcs);
        }
        user.setRoles(roles);

        return user;
    }

    public List<TUser> queryUsersByOrgId(String id) {
        List<TUser> users = userDao.selectManyByOrgId(id);

        for (TUser user : users) {
            List<TRole> roles = roleDao.selectRolesByUserId(user.getcId());
            user.setRoles(roles);
        }
        return users;
    }

    @ServiceLog
    public String addUser(TUser user, String creatorId) {

        String id = idxDao.selectNextId("t_user");
        user.setcId(id);
        user.setcCreator(creatorId);
        user.setcAvailable(true);
        user.setcCreateTime(new Date());
        userDao.insertOne(user);

        return user.getcId();
    }

    @ServiceLog
    public void modUserById(TUser user) {
        userDao.updateOneById(user);
    }

    @ServiceLog
    public void delUserById(String id) {
        userDao.deleteOneById(id);
    }

    @ServiceLog
    public void enableUserById(String id) {
        userDao.updateAvaiabilityById(id, true);
    }

    @ServiceLog
    public void disableUserById(String id) {
        userDao.updateAvaiabilityById(id, false);
    }

    @ServiceLog
    public void addUserRole(String userId, String roleId) {

        TUserRole userRole = new TUserRole();
        userRole.setcRoleId(roleId);
        userRole.setcUserId(userId);
        userRole.setcAvailable(true);

        userRoleDao.insertOne(userRole);
    }

    @ServiceLog
    @Transactional
    public void addUserRoles(String userId, String[] roleIds) {

        for (String roleId : roleIds) {
            if (StringUtils.isEmpty(roleId)) {
                continue;
            }

            if (roleDao.ifExistsById(roleId) < 1) {
                continue;
            }

            this.addUserRole(userId, roleId);
        }

    }

    @ServiceLog
    public void delUserRolesByUserId(String userId) {
        userRoleDao.deleteManyByUserId(userId);
    }
}
