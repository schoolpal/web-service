package com.schoolpal.user.db.model;

import java.util.Date;

public class TOrg {
    private String cId;

    private String cCode;

    private String cName;

    private String cNameAbbr;

    private String cAddress;

    private String cCity;

    private String cState;

    private String cCounty;

    private String cOwner;

    private String cOwnerPhone;

    private String cParentId;

    private String cRootId;

    private String cCreator;

    private Date cCreateTime;

    private String cModifier;

    private Date cModifyTime;

    private Boolean cAvailable;

    private Integer cOrderNum;
    
    private TOrg parentOrg;
    
    private TOrg rootOrg;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcNameAbbr() {
        return cNameAbbr;
    }

    public void setcNameAbbr(String cNameAbbr) {
        this.cNameAbbr = cNameAbbr == null ? null : cNameAbbr.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity == null ? null : cCity.trim();
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    public String getcCounty() {
        return cCounty;
    }

    public void setcCounty(String cCounty) {
        this.cCounty = cCounty == null ? null : cCounty.trim();
    }

    public String getcOwner() {
        return cOwner;
    }

    public void setcOwner(String cOwner) {
        this.cOwner = cOwner == null ? null : cOwner.trim();
    }

    public String getcOwnerPhone() {
        return cOwnerPhone;
    }

    public void setcOwnerPhone(String cOwnerPhone) {
        this.cOwnerPhone = cOwnerPhone == null ? null : cOwnerPhone.trim();
    }

    public String getcParentId() {
        return cParentId;
    }

    public void setcParentId(String cParentId) {
        this.cParentId = cParentId == null ? null : cParentId.trim();
    }

    public String getcRootId() {
        return cRootId;
    }

    public void setcRootId(String cRootId) {
        this.cRootId = cRootId == null ? null : cRootId.trim();
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

    public String getcModifier() {
        return cModifier;
    }

    public void setcModifier(String cModifier) {
        this.cModifier = cModifier == null ? null : cModifier.trim();
    }

    public Date getcModifyTime() {
        return cModifyTime;
    }

    public void setcModifyTime(Date cModifyTime) {
        this.cModifyTime = cModifyTime;
    }

    public Boolean getcAvailable() {
        return cAvailable;
    }

    public void setcAvailable(Boolean cAvailable) {
        this.cAvailable = cAvailable;
    }

    public Integer getcOrderNum() {
        return cOrderNum;
    }

    public void setcOrderNum(Integer cOrderNum) {
        this.cOrderNum = cOrderNum;
    }

	public TOrg getParentOrg() {
		return parentOrg;
	}

	public void setParentOrg(TOrg parentOrg) {
		this.parentOrg = parentOrg;
	}

	public TOrg getRootOrg() {
		return rootOrg;
	}

	public void setRootOrg(TOrg rootOrg) {
		this.rootOrg = rootOrg;
	}
}