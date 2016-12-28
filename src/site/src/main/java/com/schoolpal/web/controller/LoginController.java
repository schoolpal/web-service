package com.schoolpal.web.controller;

import java.util.Random;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.schoolpal.web.model.Const;
import com.schoolpal.web.model.Log;
import com.schoolpal.web.model.page.LoginForm;
import com.schoolpal.web.service.LogService;
import com.schoolpal.web.service.UserService;

@Controller
@RequestMapping("/login/")
public class LoginController {
	
	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	private Gson gson = new Gson();

	@RequestMapping(value="salt.do", method=RequestMethod.POST)
	@ResponseBody
	public String salt() {
		//
		// Generate a number between 1000 and 9999.
		//
		Random random = new Random();
		String salt = Integer.toString(random.nextInt(9000) + 1000);
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession(true);
		session.setAttribute(Const.SESSION_KEY_LOGIN_SALT, salt);
		
		logServ.log("", Log.TRACE, "LoginController.salt()", "", "Salt: " + salt);
		return salt;
	}
	
	@RequestMapping(value="access.do", method=RequestMethod.POST)
	@ResponseBody
	public String login(LoginForm login) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession(true);
		logServ.log(login.getLoginName(), Log.TRACE, "LoginController.login(LoginForm)", "", 
				String.format("LoginForm: %s; Salt: %s", gson.toJson(login), (String)session.getAttribute(Const.SESSION_KEY_LOGIN_SALT)));
		
		String error = "";
		if (userServ.login(login.getLoginName(), login.getMixedPWD())) {
			try {
				userServ.cacheUser(login.getLoginName());
			} catch (Exception ex) {
				//
				// Clear user session while getting exception.
				//
				currentUser.logout();
				
				error = "系统异常，请联系管理员！";
				logServ.log(login.getLoginName(), Log.ERROR, "LoginController.login(LoginForm)", ex.getMessage(), "LoginForm: " + gson.toJson(login));
			}
		} else {
			error = "登录失败，请确认用户名密码正确！";
		}

		logServ.log(login.getLoginName(), Log.DEBUG, "LoginController.login(LoginForm)", "", "Error: " + error);
		return error;
	}
	
}
