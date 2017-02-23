package com.schoolpal.ajax.controller;

import java.util.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.*;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.LogService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.consts.Const;
import com.schoolpal.web.consts.LogLevel;
import com.schoolpal.web.model.LoginForm;

@Controller
@RequestMapping("/ajax/user")
public class AjaxUserController {

	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
	@Autowired
	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "salt.do", method = RequestMethod.POST)
	@ResponseBody
	public String salt() {
		//
		// Generate a number between 1000 and 9999.
		//
		Random random = new Random();
		String salt = Integer.toString(random.nextInt(9000) + 1000);
		// salt = "0000";

		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession(true);
		session.setAttribute(Const.SESSION_KEY_LOGIN_SALT, salt);

		logServ.log("", LogLevel.TRACE, "AjaxUserController.salt()", "", "Salt: " + salt);

		AjaxResponse res = new AjaxResponse(200);
		res.setData(salt);

		return gson.toJson(res);
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(LoginForm login) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession(true);
		logServ.log(login.getLoginName(), LogLevel.TRACE, "AjaxUserController.login()", "",
				String.format("LoginForm: %s; Salt: %s", gson.toJson(login),
						(String) session.getAttribute(Const.SESSION_KEY_LOGIN_SALT)));

		AjaxResponse res = new AjaxResponse(200);
		if (userServ.login(login.getLoginName(), login.getMixedPWD())) {
			try {
				userServ.cacheUser(login.getLoginName());
			} catch (Exception ex) {
				currentUser.logout();

				res.setCode(500);
				res.setDetail("系统异常，请联系管理员！");
				logServ.log(login.getLoginName(), LogLevel.ERROR, "AjaxUserController.login(LoginForm)",
						ex.getMessage(), "LoginForm: " + gson.toJson(login));
			}
		} else {
			res.setCode(401);
			res.setDetail("登录失败，请确认用户名密码正确！");
		}

		logServ.log(login.getLoginName(), LogLevel.DEBUG, "AjaxUserController.login()", "",
				"Error: " + res.getDetail());

		return gson.toJson(res);
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	@ResponseBody
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		AjaxResponse res = new AjaxResponse(200);
		if (null != currentUser && null != currentUser.getPrincipal()) {
			Session session = currentUser.getSession();
			logServ.log(userServ.getCachedUser().getcLoginname(), LogLevel.TRACE, "AjaxUserController.logout()", "",
					"SESSION_KEY_CURRENT_USER: " + gson.toJson(session.getAttribute(Const.SESSION_KEY_CURRENT_USER)));
			currentUser.logout();
		} else {
			res.setCode(500);
			res.setDetail("Illegal access");
			logServ.log("", LogLevel.WARNING, "AjaxUserController.logout()", "Illegal access!");
		}

		return gson.toJson(res);
	}

	@RequestMapping(value = "status.do", method = RequestMethod.POST)
	@ResponseBody
	public String status() {
		Subject currentUser = SecurityUtils.getSubject();
		AjaxResponse res = new AjaxResponse(200);
		if (currentUser == null || currentUser.getPrincipal() == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(401);
			res.setDetail("Not login");
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "profile.do", method = RequestMethod.POST)
	@ResponseBody
	public String profile() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			res.setData(user);
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "permissions.do", method = RequestMethod.POST)
	@ResponseBody
	public String permissions() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> funcList = new ArrayList<TFunction>();
			for (TRole r : user.getRoles()) {
				funcList.addAll(r.getWidgets());
			}
			res.setData(funcList);
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "orglist.do", method = RequestMethod.POST)
	@ResponseBody
	public String orglist() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TOrg> orgList = orgServ.getOrgListByRootId(user.getcOrgId());
			res.setData(orgList);
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "rolelist.do", method = RequestMethod.POST)
	@ResponseBody
	public String rolelist(String orgId) {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			if (!orgServ.getOrgIdListByRootId(user.getcOrgId()).contains(orgId)) {
				res.setCode(401);
				res.setDetail("No permission for this orgnization");
			} else {
				List<TRole> roleList = roleServ.getRoleListByOrgId(orgId);
				res.setData(roleList);
			}
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "funclist.do", method = RequestMethod.POST)
	@ResponseBody
	public String funclist(String roleId) {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			TRole role = roleServ.getRoleById(roleId);
			if (!orgServ.getOrgIdListByRootId(user.getcOrgId()).contains(role.getcOrgId())) {
				res.setCode(401);
				res.setDetail("No permission for this orgnization");
			} else {
				List<TFunction> funcList = funcServ.getFuncListByRoleId(roleId);
				res.setData(funcList);
			}
		}
		return gson.toJson(res);
	}

}
