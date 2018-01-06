package com.schoolpal.web.model;

import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;

import javax.validation.constraints.NotEmpty;

public class RoleForm {

	@NotEmpty(groups = {AjaxControllerMod.class})
	private String id;
	@NotEmpty(groups = {AjaxControllerAdd.class, AjaxControllerMod.class})
	private String orgId;
	private String orgHierarchy;
	private String strFuncIds;
	private int rankId;
	@NotEmpty(groups = {AjaxControllerAdd.class})
	private String name;
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public String getStrFuncIds() {
		return strFuncIds;
	}
	public void setStrFuncIds(String strFuncIds) {
		this.strFuncIds = strFuncIds;
	}
	public String getOrgHierarchy() {
		return orgHierarchy;
	}
	public void setOrgHierarchy(String orgHierarchy) {
		this.orgHierarchy = orgHierarchy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
