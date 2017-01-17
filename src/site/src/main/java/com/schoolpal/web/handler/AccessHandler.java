package com.schoolpal.web.handler;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.UserService;

public class AccessHandler extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userServ;
	
	private List<String> ignorePatterns;
	
	public void setIgnorePatterns(List<String> patterns) {
		this.ignorePatterns = patterns;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//
		// TODO: There should be enhanced!
		//
		TUser user = userServ.getCachedUser();
		if (user != null) {
			String accessUrl = request.getRequestURL().toString();
			for (String strPattern : ignorePatterns) {
				Pattern pattern = Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE);
				if (pattern.matcher(accessUrl).matches()) {
					return true;
				}
			}
			
			for (TFunction func : user.getWidgets()) {
				if (accessUrl.endsWith(func.getcAction())) {
					return true;
				}
			}
			response.getWriter().write("Access Denied!");
			return false;
		}
		return true;
	}

}
