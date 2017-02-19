package com.schoolpal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
import com.schoolpal.web.consts.*;

@Service
public class UserService  {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private TUserMapper userDao; 
	@Autowired
	private TOrgMapper orgDao; 
	@Autowired
	private TRoleMapper roleDao; 
	@Autowired
	private TFunctionMapper funcDao; 
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
			
			logServ.log(username, LogLevel.TRACE, "LoginService.login(String,String)", "", "Login-Success: " + username);
		} catch(Exception ex) {
			logServ.log(username, LogLevel.WARNING, "LoginService.login(String,String)", ex.getMessage(), "Username: " + username + ", MixedPWD: " + mixedPWD);
			return false;
		}
		return true;
	}
	
	private TUser queryUserByLoginName(String username){
		TUser user = userDao.selectOneByLoginName(username);
		
		//Get orgs
		TOrg org = orgDao.selectOneById(user.getcOrgId());
		user.setOrg(org);
		
		//Get roles
		List<TRole> roles = roleDao.selectRolesByUserId(user.getcId());
		for(TRole role : roles){
			List<TFunction> funcs = funcDao.selectFuncsByRoleId(role.getcId());
			role.setWidgets(funcs);
		}
		user.setRoles(roles);
		
		return user;
	}
	
	public void cacheUser(String username) {
		TUser user = this.queryUserByLoginName(username);
		
		String jsonUser = gson.toJson(user);
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute(Const.SESSION_KEY_CURRENT_USER, jsonUser);
		
		logServ.log(username, LogLevel.TRACE, "LoginService.cacheUserData(String)", "", "SESSION_KEY_CURRENT_USER: " + jsonUser);
	}
	
	public TUser getCachedUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null || currentUser.getPrincipal() == null) {
			return null;
		}
		
		Session session = currentUser.getSession(true);
		return gson.fromJson((String)session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
	}

}
