package com.schoolpal.web.model.page.config;

public class OrgForm {
	
	private String id;
	private String cnFullName;
	private String orgCode;
	private String parentId;
	private String parentCnFullName;
	private String province;
	private String city;
	private String county;
	private String address;
	private String owner;
	private String phone;
	
	public String getCnFullName() {
		return cnFullName;
	}
	public void setCnFullName(String cnFullName) {
		this.cnFullName = cnFullName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentCnFullName() {
		return parentCnFullName;
	}
	public void setParentCnFullName(String parentCnFullName) {
		this.parentCnFullName = parentCnFullName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
