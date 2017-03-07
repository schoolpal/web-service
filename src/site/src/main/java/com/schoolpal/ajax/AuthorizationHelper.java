package com.schoolpal.ajax;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerMapping;

import com.schoolpal.service.FunctionService;

@Component
public class AuthorizationHelper {

	private static FunctionService funcServ;

	@Autowired
	public void setFuncServ(FunctionService funcServ) {
		AuthorizationHelper.funcServ = funcServ;
	}

	public static boolean CheckPermissionByMappedPath(String actionPath) {
		String permissionId = funcServ.getFunctionIdByActionPath(actionPath);
		if (permissionId == null || permissionId.isEmpty()) {
			return false;
		}

		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null) {
			return false;
		} else {
			return currentUser.isPermitted(permissionId);
		}
	}

	public static boolean CheckPermissionById(String id) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser == null) {
			return false;
		} else {
			return currentUser.isPermitted(id);
		}
	}

}
