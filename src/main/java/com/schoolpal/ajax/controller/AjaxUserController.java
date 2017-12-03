package com.schoolpal.ajax.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

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

@Controller
@RequestMapping("/ajax/user")
public class AjaxUserController {

	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "salt.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse salt() {
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

		return res;
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse login(LoginForm login) {
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
				res.setDetail("Failed to login, unexpect error");
				logServ.log(login.getLoginName(), LogLevel.ERROR, "AjaxUserController.login(LoginForm)",
						ex.getMessage(), "LoginForm: " + gson.toJson(login));
			}
		} else {
			res.setCode(401);
			res.setDetail("Failed to login, wrong user/pass");
		}

		logServ.log(login.getLoginName(), LogLevel.DEBUG, "AjaxUserController.login()", "",
				"Error: " + res.getDetail());

		return res;
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse logout() {
		Subject currentUser = SecurityUtils.getSubject();
		AjaxResponse res = new AjaxResponse(200);
		if (null != currentUser && null != currentUser.getPrincipal()) {
			String username = userServ.getCachedUser().getcLoginname();
			Session session = currentUser.getSession();
			logServ.log(userServ.getCachedUser().getcLoginname(), LogLevel.TRACE, "AjaxUserController.logout()", "",
					"SESSION_KEY_CURRENT_USER: " + gson.toJson(session.getAttribute(Const.SESSION_KEY_CURRENT_USER)));

			currentUser.logout();
			userServ.clearUserCache(username);
		} else {
			res.setCode(500);
			res.setDetail("Illegal access");
			logServ.log("", LogLevel.WARNING, "AjaxUserController.logout()", "Illegal access!");
		}

		return res;
	}

	@RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse changePassword(String oriPass, String newPass, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (oriPass == null || oriPass.isEmpty()) {
				res.setCode(402);
				res.setDetail("Original password cannot be empty");
				break;
			}
			if (newPass == null || newPass.isEmpty()) {
				res.setCode(403);
				res.setDetail("New password cannot be empty");
				break;
			}
			if (oriPass == newPass) {
				res.setCode(404);
				res.setDetail("Original and new password cannot be same");
				break;
			}

			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser == null || currentUser.getPrincipal() == null) {
				// Since shiro shiro will intercept if not login, this code should
				// never be reached
				res.setCode(401);
				res.setDetail("Not login");
			}
			
			TUser user = userServ.getCachedUser(currentUser);
			if (!oriPass.equals(userServ.queryLoginPassByName(user.getcLoginname()))) {
				res.setCode(405);
				res.setDetail("Wrong original password");
				break;
			}
			
			boolean result = userServ.changeLoginPassById(user.getcId(), oriPass, newPass);
			res.setData(result);
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "status.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse status() {
		Subject currentUser = SecurityUtils.getSubject();
		AjaxResponse res = new AjaxResponse(200);
		if (currentUser == null || currentUser.getPrincipal() == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(401);
			res.setDetail("Not login");
		}
		return res;
	}

	@RequestMapping(value = "profile.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse profile() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			res.setData(user);
		}
		return res;
	}

	@RequestMapping(value = "listOrgs.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listOrgs() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TOrg> orgList = orgServ.queryOrgListByRootIdLite(user.getcOrgId());
			res.setData(orgList);
		}
		return res;
	}

	@RequestMapping(value = "listRoles.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listRoles() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TRole> roleList = user.getRoles();
			res.setData(roleList);
		}
		return res;
	}

	@RequestMapping(value = "listFuncs.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listFuncs() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> funcList = new ArrayList<TFunction>();
			for (TRole r : user.getRoles()) {
				funcList.addAll(r.getFunctions());
			}
			res.setData(funcList);
		}
		return res;
	}

	@RequestMapping(value = "listFuncsByRole.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listFuncsByRole(String id) {
		AjaxResponse res = new AjaxResponse(200);

		do {
			TUser user = userServ.getCachedUser();
			if (user == null) {
				res.setCode(500);
				res.setDetail("Cannot find cached profile data, not login?");
				break;
			}

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
