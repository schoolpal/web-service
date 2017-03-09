package com.schoolpal.service;

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
import com.schoolpal.web.model.OrgForm;
import com.schoolpal.web.model.UserForm;

@Service
public class UserService  {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private TIndexMapper idxDao;
	@Autowired
	private TUserMapper userDao; 
	@Autowired
	private TOrgMapper orgDao; 
	@Autowired
	private TRoleMapper roleDao; 
	@Autowired
	private TRoleFunctionMapper roleFuncDao; 
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
			
			logServ.log(username, LogLevel.TRACE, "UserService.login(String,String)", "", "Login-Success: " + username);
		} catch(Exception ex) {
			logServ.log(username, LogLevel.WARNING, "UserService.login(String,String)", ex.getMessage(), "Username: " + username + ", MixedPWD: " + mixedPWD);
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
			List<TFunction> funcs = roleFuncDao.selectAllFuncsByRoleId(role.getcId());
			role.setFunctions(funcs);
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
		
		logServ.log(username, LogLevel.TRACE, "UserService.cacheUserData(String)", "", "SESSION_KEY_CURRENT_USER: " + jsonUser);
	}
	
	public TUser getCachedUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null || currentUser.getPrincipal() == null) {
			return null;
		}
		
		Session session = currentUser.getSession(true);
		return gson.fromJson((String)session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
	}
	
	public void clearUserCache(String username) {		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.removeAttribute(Const.SESSION_KEY_CURRENT_USER);
		
		logServ.log(username, LogLevel.TRACE, "UserService.clearUserCache(String)", "", "");
	}
	
	public String addUser(UserForm form, String creatorId){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_user");
			TUser user = this.userFormToTUser(form);
			user.setcId(id);
			user.setcCreator(creatorId);
			user.setcAvailable(true);
			if (userDao.insertOne(user) > 0){
				ret = id;
			}
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "UserService.AddOrg()", "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modUserById(UserForm form){
		boolean ret = false;
		try{
			TUser user = this.userFormToTUser(form);
			ret = userDao.updateOneById(user) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "UserService.ModOrg()", "", e.getMessage());
		}
		return ret;
	}
		
	public boolean delUserById(String id){
		boolean ret = false;
		try{
			ret = userDao.deleteOneById(id) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "UserService.DelOrgById()", "", e.getMessage());
		}
		return ret;
	}
	
	public TUser userFormToTUser(UserForm form){
		TUser user = new TUser();
		user.setcId(form.getUserId());
		user.setcLoginname(form.getLoginName());
		user.setcLoginpass(form.getLoginPass());
		user.setcNickname(form.getNickName());
		user.setcAvailable(true);
		user.setcOrgId(form.getOrgId());
		user.setcEmail(form.getEmail());
		user.setcPhone(form.getPhone());
		user.setcQq(form.getIm());
		user.setcRealname(form.getRealName());
		return user;
	}
}
