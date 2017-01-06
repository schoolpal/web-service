package com.schoolpal.db.model;

import java.util.Date;

public class TRole {
    private String cId;

    private String cOrgId;

    private String cName;

    private String cDesc;

    private Boolean cAvailable;

    private Integer cOrderNum;

    private Integer cRankId;

    private String cCreator;

    private Date cCreateTime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcOrgId() {
        return cOrgId;
    }

    public void setcOrgId(String cOrgId) {
        this.cOrgId = cOrgId == null ? null : cOrgId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
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

    public Integer getcRankId() {
        return cRankId;
    }

    public void setcRankId(Integer cRankId) {
        this.cRankId = cRankId;
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
}