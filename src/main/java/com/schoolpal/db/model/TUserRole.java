package com.schoolpal.db.model;

import java.util.Date;

public class TUserRole {
    private String cUserId;

    private String cRoleId;

    private Boolean cAvailable;

    private String cCreator;

    private Date cCreateTime;

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public String getcRoleId() {
        return cRoleId;
    }

    public void setcRoleId(String cRoleId) {
        this.cRoleId = cRoleId == null ? null : cRoleId.trim();
    }

    public Boolean getcAvailable() {
        return cAvailable;
    }

    public void setcAvailable(Boolean cAvailable) {
        this.cAvailable = cAvailable;
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