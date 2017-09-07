package com.schoolpal.ajax;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AjaxAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		if (this.isLoginRequest(request, response)) {
			if (this.isLoginSubmission(request, response)) {
				return this.executeLogin(request, response);
			} else {
				return true;
			}
		} else {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.sendError(401);
			return false;
		}
	}
/*
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {// 不是ajax请求
			issueSuccessRedirect(request, response);
		} else {
			httpServletResponse.setCharacterEncoding("UTF-8");
			PrintWriter out = httpServletResponse.getWriter();
			out.println("{\"success\":true,\"message\":\"登入成功\"}");
			out.flush();
			out.close();
		}
		return false;
	}
*/
	/**
	 * * 当登录失败 * @param token * @param e * @param request * @param response
	 * * @return
	 */
/*
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
			setFailureAttribute(request, e);
			return true;
		}
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String message = e.getClass().getSimpleName();
			if ("IncorrectCredentialsException".equals(message)) {
				out.println("{\"success\":false,\"message\":\"密码错误\"}");
			} else if ("UnknownAccountException".equals(message)) {
				out.println("{\"success\":false,\"message\":\"账号不存在\"}");
			} else if ("LockedAccountException".equals(message)) {
				out.println("{\"success\":false,\"message\":\"账号被锁定\"}");
			} else {
				out.println("{\"success\":false,\"message\":\"未知错误\"}");
			}
			out.flush();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	*/
}
