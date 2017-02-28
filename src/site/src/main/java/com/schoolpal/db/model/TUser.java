package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TUser {
    private String cId;

    private String cLoginname;

    private String cLoginpass;

    private String cRealname;

    private String cNickname;

    private String cPhone;

    private String cEmail;

    private String cQq;

    private Boolean cAvailable;

    private String cOrgId;

    private String cOrgRootId;

    private String cCreator;

    private Date cCreateTime;

    private Date cLastVisitTime;

    private String cLastVisitIp;

	private TOrg org;

	private List<TRole> roles;
	
	private Map<String, TRole> roleIndex = new HashMap<String, TRole>();
	
	public TRole getRoleById(String roleId){
		return this.roleIndex.get(roleId);
	}
	
	public List<String> getRoleIds() {
		return new ArrayList<String>(this.roleIndex.keySet());
	}
	
	public List<TFunction> getWidgets() {
		List<TFunction> funcs = new ArrayList<TFunction>();
		for (TRole role : roles) {
			funcs.addAll(role.getFunctions());
		}
		return funcs;
	}
	
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcLoginname() {
        return cLoginname;
    }

    public void setcLoginname(String cLoginname) {
        this.cLoginname = cLoginname == null ? null : cLoginname.trim();
    }

    public String getcLoginpass() {
        return cLoginpass;
    }

    public void setcLoginpass(String cLoginpass) {
        this.cLoginpass = cLoginpass == null ? null : cLoginpass.trim();
    }

    public String getcRealname() {
        return cRealname;
    }

    public void setcRealname(String cRealname) {
        this.cRealname = cRealname == null ? null : cRealname.trim();
    }

    public String getcNickname() {
        return cNickname;
    }

    public void setcNickname(String cNickname) {
        this.cNickname = cNickname == null ? null : cNickname.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcQq() {
        return cQq;
    }

    public void setcQq(String cQq) {
        this.cQq = cQq == null ? null : cQq.trim();
    }

    public Boolean getcAvailable() {
        return cAvailable;
    }

    public void setcAvailable(Boolean cAvailable) {
        this.cAvailable = cAvailable;
    }

    public String getcOrgId() {
        return cOrgId;
    }

    public void setcOrgId(String cOrgId) {
        this.cOrgId = cOrgId == null ? null : cOrgId.trim();
    }

    public String getcOrgRootId() {
        return cOrgRootId;
    }

    public void setcOrgRootId(String cOrgRootId) {
        this.cOrgRootId = cOrgRootId == null ? null : cOrgRootId.trim();
    }

    public String getcCreator() {
        return cCreator;
    }

    public void setcCreator(String cCreator) {
        this.cCreator = cCreator == null ? null : cCreator.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Date getcLastVisitTime() {
        return cLastVisitTime;
    }

    public void setcLastVisitTime(Date cLastVisitTime) {
        this.cLastVisitTime = cLastVisitTime;
    }

    public String getcLastVisitIp() {
        return cLastVisitIp;
    }

    public void setcLastVisitIp(String cLastVisitIp) {
        this.cLastVisitIp = cLastVisitIp == null ? null : cLastVisitIp.trim();
    }

	public TOrg getOrg() {
		return org;
	}

	public void setOrg(TOrg org) {
		this.org = org;
	}

	public List<TRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TRole> roles) {
		this.roles = roles;
		this.roleIndex.clear();
		for (TRole r : roles){
			this.roleIndex.put(r.getcId(), r);
		}
	}
}