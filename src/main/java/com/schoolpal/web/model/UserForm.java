package com.schoolpal.web.model;

import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;

import javax.validation.constraints.NotEmpty;

public class UserForm {

	@NotEmpty(groups = {AjaxControllerMod.class})
	private String userId;
	@NotEmpty(groups = {AjaxControllerAdd.class})
	private String orgId;
	@NotEmpty(groups = {AjaxControllerAdd.class})
	private String loginName;
	@NotEmpty(groups = {AjaxControllerAdd.class})
	private String loginPass;
	private String realName;
	private String nickName;
	private String phone;
	private String email;
	private String im;
	@NotEmpty(groups = {AjaxControllerAdd.class})
	private String roles;

	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String passwd) {
		this.loginPass = passwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

}
