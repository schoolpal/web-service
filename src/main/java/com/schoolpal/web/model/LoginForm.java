package com.schoolpal.web.model;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty
	private String loginName;

	@NotEmpty
	private String mixedPWD;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMixedPWD() {
		return mixedPWD;
	}
	public void setMixedPWD(String mixedPWD) {
		this.mixedPWD = mixedPWD;
	}

}
