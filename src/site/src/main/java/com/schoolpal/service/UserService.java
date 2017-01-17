package com.schoolpal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.schoolpal.db.*;
import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
import com.schoolpal.web.model.*;
import com.schoolpal.web.model.page.*;

@Service
public class UserService  {
	
	@Autowired
	private HttpServletRequest request;
/*	@Autowired
	private UserDB userDB;*/
	@Autowired
	private TUserMapper userDao; 
	@Autowired
	private TRoleMapper roleDao; 
	@Autowired
	private LogService logServ;
	private Gson gson = new Gson();
	
	public boolean login(String username, String mixedPWD) {
		if (username == null || username.isEmpty()) {
			return false;
		}
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, mixedPWD, false);
		try {
			currentUser.login(token);
			
			this.userDao.updateLastVisitByLoginName(username, request.getRemoteAddr());
			
			logServ.log(username, Log.TRACE, "LoginService.login(String,String)", "", "Login-Success: " + username);
		} catch(Exception ex) {
			logServ.log(username, Log.WARNING, "LoginService.login(String,String)", ex.getMessage(), "Username: " + username + ", MixedPWD: " + mixedPWD);
			return false;
		}
		return true;
	}
	
	public void cacheUser(String username) {
		
		TUser user = userDao.selectOneByLoginName(username);
		List<String> roleIds = roleDao.selectRoleIdsByUserId(user.getcId());
		List<TRole> roles = new ArrayList<TRole>();
		for(String id : roleIds){
			TRole r = roleDao.selectOneById(id);
			if (r != null){
				roles.add(r);
			}
		}
		user.setRoles(roles);
		
		String jsonUser = gson.toJson(user);
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute(Const.SESSION_KEY_CURRENT_USER, jsonUser);
		
		logServ.log(username, Log.TRACE, "LoginService.cacheUserData(String)", "", "SESSION_KEY_CURRENT_USER: " + jsonUser);
	}
	
	public TUser getCachedUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null || currentUser.getPrincipal() == null) {
			return null;
		}
		
		Session session = currentUser.getSession(true);
		return gson.fromJson((String)session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
	}

	public List<Menu> buildMenus(List<TFunction> widgets) {
		List<Menu> menus = new ArrayList<Menu>();
		List<MenuItem> items = new ArrayList<MenuItem>();
		
		for (TFunction widget : widgets) {
			switch (widget.getWidgetType()) {
			case "Menu":
				Menu menu = new Menu();
				menu.setId(widget.getcId());
				menu.setText(widget.getcNameLong());
				menu.setOrder(widget.getcOrderNum());
				menu.setIcon(widget.getcIcon());
				menu.setItems(new ArrayList<MenuItem>());
				menus.add(menu);
				break;
			case "MenuItem":
				MenuItem item = new MenuItem();
				item.setId(widget.getcId());
				item.setParentId(widget.getcParentId());
				item.setText(widget.getcNameLong());
				item.setAction(widget.getcAction());
				item.setOrder(widget.getcOrderNum());
				item.setIcon(widget.getcIcon());
				items.add(item);
				break;
			}
		}
		
		Collections.sort(menus);
		for (Menu menu : menus) {
			for (MenuItem item : items) {
				if (item.getParentId().equals(menu.getId())) {
					List<MenuItem> its = menu.getItems();
					its.add(item);
				}
			}
			Collections.sort(menu.getItems());
		}
		return menus;
	}
	
	public List<Button> buildButtons(List<TFunction> widgets, String parentId) {
		List<Button> buttons = new ArrayList<Button>();
		for (TFunction widget : widgets) {
			if (!widget.getcParentId().equals(parentId) || !widget.getWidgetType().endsWith("Button")) {
				continue;
			}
			
			Button button = new Button();
			button.setId(widget.getcId());
			button.setType(widget.getWidgetType());
			button.setText(widget.getcNameLong());
			button.setAction(widget.getcAction());
			button.setIcon(widget.getcIcon());
			button.setOrder(widget.getcOrderNum());
			buttons.add(button);
		}
		Collections.sort(buttons);
		return buttons;
	}

}
