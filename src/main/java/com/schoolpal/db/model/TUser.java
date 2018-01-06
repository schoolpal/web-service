package com.schoolpal.db.model;

import java.util.*;

public class TUser {
    private String cId;

    private String cLoginName;

    private String cLoginPass;

    private String cRealName;

    private String cNickName;

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
	
	public List<TFunction> getFuncs() {
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

    public String getcLoginName() {
        return cLoginName;
    }

    public void setcLoginName(String cLoginName) {
        this.cLoginName = cLoginName == null ? null : cLoginName.trim();
    }

    public String getcLoginPass() {
        return cLoginPass;
    }

    public void setcLoginPass(String cLoginPass) {
        this.cLoginPass = cLoginPass == null ? null : cLoginPass.trim();
    }

    public String getcRealName() {
        return cRealName;
    }

    public void setcRealName(String cRealName) {
        this.cRealName = cRealName == null ? null : cRealName.trim();
    }

    public String getcNickName() {
        return cNickName;
    }

    public void setcNickName(String cNickName) {
        this.cNickName = cNickName == null ? null : cNickName.trim();
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