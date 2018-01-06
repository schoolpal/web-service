package com.schoolpal.web.shiro;

import com.google.gson.Gson;
import com.schoolpal.consts.Const;
import com.schoolpal.db.inf.TUserMapper;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

public class AuthorizingService extends AuthorizingRealm {

	private final static String REALM_NAME = "SchoolPal_ShiroRealm";

	@Autowired
	private TUserMapper userDAO;
	private Gson gson = new Gson();

	public AuthorizingService() {
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
