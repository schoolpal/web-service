package com.schoolpal.service;

import java.security.NoSuchAlgorithmException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
import com.schoolpal.web.consts.*;
import com.schoolpal.web.util.MD5;

public class RealmService extends AuthorizingRealm {

	private final static String REALM_NAME = "SchoolPal_ShiroRealm";

	@Autowired
	private TUserMapper userDAO;
	private Gson gson = new Gson();

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
			mixedPWD = MD5.encode(userDAO.selectPasswordByLoginName(username) + salt);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return new SimpleAuthenticationInfo(username, mixedPWD, getName());
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null || currentUser.getPrincipal() == null) {
			return null;
		}

		Session session = currentUser.getSession(true);
		TUser cachedUser = gson.fromJson((String) session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (TRole r : cachedUser.getRoles()) {
			info.addRole(r.getcId());
			info.addStringPermissions(r.getAllFuncIds());
		}
		return info;
	}

}
