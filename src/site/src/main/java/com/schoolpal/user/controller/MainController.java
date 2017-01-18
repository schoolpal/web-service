package com.schoolpal.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.schoolpal.service.LogService;
import com.schoolpal.user.db.model.TUser;
import com.schoolpal.user.model.page.MainPage;
import com.schoolpal.user.service.UserService;
import com.schoolpal.web.consts.Const;
import com.schoolpal.web.consts.Log;

@Controller
@RequestMapping("/main/")
public class MainController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private LogService logServ;
	private Gson gson = new Gson();

	@RequestMapping("index.html")
	public ModelAndView index() {
		TUser user = userServ.getCachedUser();
		MainPage page = new MainPage();
		page.setOrgName(user.getOrg().getcName());
		page.setWelcomeName(user.getcLoginname());
		page.setOrgCode(user.getOrg().getcCode());
		page.setMenus(userServ.buildMenus(user.getWidgets()));

		logServ.log(user.getcLoginname(), Log.TRACE, "MainController.index()", "", 
				String.format("Username: %s; Page: %s", user.getcLoginname(), gson.toJson(page)));
		return new ModelAndView("main/index", "page", page);
	}
	
	@RequestMapping(value="logout.html")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser && null != currentUser.getPrincipal()) {
			Session session = currentUser.getSession();
			logServ.log(userServ.getCachedUser().getcLoginname(), Log.TRACE, "MainController.logout()", "", 
					"SESSION_KEY_CURRENT_USER: " + gson.toJson(session.getAttribute(Const.SESSION_KEY_CURRENT_USER)));
			currentUser.logout();
		} else {
			logServ.log("", Log.WARNING, "MainController.logout()", "Illegal access!");
		}
		return "redirect:/";
	}
	
}
