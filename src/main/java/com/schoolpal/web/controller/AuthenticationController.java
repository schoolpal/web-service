package com.schoolpal.web.controller;

import com.google.gson.Gson;
import com.schoolpal.web.ajax.model.AjaxResponse;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.LogService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.UserService;
import com.schoolpal.consts.Const;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.web.model.LoginForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class AuthenticationController {

	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "login.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object login(LoginForm login, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser != null && currentUser.getPrincipal() != null) {
			mv.setViewName("status");
			TUser user = userServ.getCachedUser();
			mv.addObject("profile", user);
			return mv;
		}

		if (request.getMethod().equals("GET")){
			mv.setViewName("login");
			return mv;

		}else {

			Session session = currentUser.getSession(true);
			logServ.log(login.getLoginName(), LogLevel.TRACE, "AuthenticationController.login()", "",
					String.format("LoginForm: %s; Salt: %s", gson.toJson(login),
							(String) session.getAttribute(Const.SESSION_KEY_LOGIN_SALT)));

			AjaxResponse res = new AjaxResponse(200);
			if (userServ.login(login.getLoginName(), login.getMixedPWD())) {
				try {
					TUser user = userServ.cacheUser(login.getLoginName());
					mv.setViewName("status");
					mv.addObject("profile", user);
					return mv;
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
	}

	@RequestMapping(value = "logout.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object logout() {
		ModelAndView mv = new ModelAndView();

		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser && null != currentUser.getPrincipal()) {
			String username = userServ.getCachedUser().getcLoginname();
			Session session = currentUser.getSession();
			logServ.log(userServ.getCachedUser().getcLoginname(), LogLevel.TRACE, "AjaxUserController.logout()", "",
					"SESSION_KEY_CURRENT_USER: " + gson.toJson(session.getAttribute(Const.SESSION_KEY_CURRENT_USER)));

			currentUser.logout();
			userServ.clearUserCache(username);

		} else {
			logServ.log("", LogLevel.WARNING, "AjaxUserController.logout()", "Illegal access!");

		}

		mv.setViewName("redirect:/login.do");
		return mv;
	}

}
