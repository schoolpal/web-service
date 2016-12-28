package com.schoolpal.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.schoolpal.web.model.Const;
import com.schoolpal.web.model.Log;
import com.schoolpal.web.model.User;
import com.schoolpal.web.model.page.MainPage;
import com.schoolpal.web.service.LogService;
import com.schoolpal.web.service.UserService;

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
		User user = userServ.getCachedUser();
		MainPage page = new MainPage();
		page.setOrgName(user.getOrg().getName());
		page.setWelcomeName(user.getLoginName());
		page.setOrgCode(user.getOrg().getCode());
		page.setMenus(userServ.buildMenus(user.getWidgets()));

		logServ.log(user.getLoginName(), Log.TRACE, "MainController.index()", "", 
				String.format("Username: %s; Page: %s", user.getLoginName(), gson.toJson(page)));
		return new ModelAndView("main/index", "page", page);
	}
	
	@RequestMapping(value="logout.html")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser && null != currentUser.getPrincipal()) {
			Session session = currentUser.getSession();
			logServ.log(userServ.getCachedUser().getLoginName(), Log.TRACE, "MainController.logout()", "", 
					"SESSION_KEY_CURRENT_USER: " + gson.toJson(session.getAttribute(Const.SESSION_KEY_CURRENT_USER)));
			currentUser.logout();
		} else {
			logServ.log("", Log.WARNING, "MainController.logout()", "Illegal access!");
		}
		return "redirect:/";
	}
	
}
