package com.schoolpal.db.model;

import java.util.Date;

public class TLog {
    private String cId;

    private String cCreator;

    private Date cCreateTime;

    private String cType;

    private String cTitle;

    private String cDesc;

    private String cServiceIp;

    private String cUserIp;

    private String cDebug;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
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

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle == null ? null : cTitle.trim();
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
    }

    public String getcServiceIp() {
        return cServiceIp;
    }

    public void setcServiceIp(String cServiceIp) {
        this.cServiceIp = cServiceIp == null ? null : cServiceIp.trim();
    }

    public String getcUserIp() {
        return cUserIp;
    }

    public void setcUserIp(String cUserIp) {
        this.cUserIp = cUserIp == null ? null : cUserIp.trim();
    }

    public String getcDebug() {
        return cDebug;
    }

    public void setcDebug(String cDebug) {
        this.cDebug = cDebug == null ? null : cDebug.trim();
    }
}