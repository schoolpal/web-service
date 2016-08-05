package com.schoolpal.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.schoolpal.web.db.UserDB;
import com.schoolpal.web.model.Const;
import com.schoolpal.web.model.Log;
import com.schoolpal.web.model.Role;
import com.schoolpal.web.model.User;
import com.schoolpal.web.model.Widget;
import com.schoolpal.web.model.page.Button;
import com.schoolpal.web.model.page.Menu;
import com.schoolpal.web.model.page.MenuItem;

@Service
public class UserService  {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserDB userDB;
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
			userDB.updateLastVisit(username, request.getRemoteAddr());
			logServ.log(username, Log.TRACE, "LoginService.login(String,String)", "", "Login-Success: " + username);
		} catch(Exception ex) {
			logServ.log(username, Log.WARNING, "LoginService.login(String,String)", ex.getMessage(), "Username: " + username + ", MixedPWD: " + mixedPWD);
			return false;
		}
		return true;
	}
	
	public void cacheUser(String username) {
		User user = userDB.getUser(username);
		
		List<Role> roles = userDB.getRoles(user.getId());
		user.setRoles(roles);
		
		Map<String, List<Widget>> map = userDB.getWidgets(user.getRoleIds());
		for (Role role : user.getRoles()) {
			role.setWidgets(map.get(role.getId()));
		}
		
		String jsonUser = gson.toJson(user);
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute(Const.SESSION_KEY_CURRENT_USER, jsonUser);
		
		logServ.log(username, Log.TRACE, "LoginService.cacheUserData(String)", "", "SESSION_KEY_CURRENT_USER: " + jsonUser);
	}
	
	public User getCachedUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null || currentUser.getPrincipal() == null) {
			return null;
		}
		
		Session session = currentUser.getSession(true);
		return gson.fromJson((String)session.getAttribute(Const.SESSION_KEY_CURRENT_USER), User.class);
	}

	public List<Menu> buildMenus(List<Widget> widgets) {
		List<Menu> menus = new ArrayList<Menu>();
		List<MenuItem> items = new ArrayList<MenuItem>();
		
		for (Widget widget : widgets) {
			switch (widget.getType()) {
			case "Menu":
				Menu menu = new Menu();
				menu.setId(widget.getId());
				menu.setText(widget.getText());
				menu.setOrder(widget.getOrder());
				menu.setIcon(widget.getIcon());
				menu.setItems(new ArrayList<MenuItem>());
				menus.add(menu);
				break;
			case "MenuItem":
				MenuItem item = new MenuItem();
				item.setId(widget.getId());
				item.setParentId(widget.getParentId());
				item.setText(widget.getText());
				item.setAction(widget.getAction());
				item.setOrder(widget.getOrder());
				item.setIcon(widget.getIcon());
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
	
	public List<Button> buildButtons(List<Widget> widgets, String parentId) {
		List<Button> buttons = new ArrayList<Button>();
		for (Widget widget : widgets) {
			if (!widget.getParentId().equals(parentId) || !widget.getType().endsWith("Button")) {
				continue;
			}
			
			Button button = new Button();
			button.setId(widget.getId());
			button.setType(widget.getType());
			button.setText(widget.getText());
			button.setAction(widget.getAction());
			button.setIcon(widget.getIcon());
			button.setOrder(widget.getOrder());
			buttons.add(button);
		}
		Collections.sort(buttons);
		return buttons;
	}

}
