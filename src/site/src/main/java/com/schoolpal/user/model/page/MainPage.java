package com.schoolpal.user.model.page;

import java.util.List;

public class MainPage {
	
	private String orgCode;
	private String orgName;
	private String welcomeName;
	private List<Menu> menus;
	
	public String getWelcomeName() {
		return welcomeName;
	}
	public void setWelcomeName(String welcomeName) {
		this.welcomeName = welcomeName;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
