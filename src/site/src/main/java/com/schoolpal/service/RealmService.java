package com.schoolpal.service;

import java.security.NoSuchAlgorithmException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.schoolpal.db.*;
import com.schoolpal.web.model.*;
import com.schoolpal.web.util.MD5;

public class RealmService extends AuthenticatingRealm {

	private final static String REALM_NAME = "SchoolPal_ShiroRealm";

/*	@Autowired
	private UserDB userDB;*/
	@Autowired
	private UserService userService;

	public RealmService() {
		setName(REALM_NAME);
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession(true);
		String salt = (String) session.getAttribute(Const.SESSION_KEY_LOGIN_SALT);
		if (salt == null) {
			return null;
		}

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		String mixedPWD = "";
		try {
//			mixedPWD = MD5.encode(userDB.getUserLoginPWD(username) + salt);
			mixedPWD = MD5.encode(userService.GetUserLoginPassByName(username) + salt);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return new SimpleAuthenticationInfo(username, mixedPWD, getName());
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("ROLE_USER");
		info.addStringPermission("user:all");
		return info;
	}

}
