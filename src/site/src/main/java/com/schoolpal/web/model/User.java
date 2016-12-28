package com.schoolpal.web.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String id;
	private String loginName;
	private Org org;
	private List<Role> roles;
	
	public List<String> getRoleIds() {
		List<String> ids = new ArrayList<String>();
		for (Role role : roles) {
			ids.add(role.getId());
		}
		return ids;
	}
	
	public List<Widget> getWidgets() {
		List<Widget> widgets = new ArrayList<Widget>();
		for (Role role : roles) {
			widgets.addAll(role.getWidgets());
		}
		return widgets;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}

}
