package com.schoolpal.web.model;

public class Org {
	
	private String id;
	private String cnFullName;
	private String code;
	private String parentCode;
	private String rootCode;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getRootCode() {
		return rootCode;
	}
	public void setRootCode(String rootCode) {
		this.rootCode = rootCode;
	}
	public String getCnFullName() {
		return cnFullName;
	}
	public void setCnFullName(String cnFullName) {
		this.cnFullName = cnFullName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
