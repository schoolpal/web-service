package com.schoolpal.web.model.page;

import java.util.List;

public class RoleRow {
	
	private String id;
	private List<String> funcNames;
	private String rankName;
	private String name;
	private String desc;
	private int rankId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
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
	public List<String> getFuncNames() {
		return funcNames;
	}
	public void setFuncNames(List<String> funcNames) {
		this.funcNames = funcNames;
	}
	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

}
