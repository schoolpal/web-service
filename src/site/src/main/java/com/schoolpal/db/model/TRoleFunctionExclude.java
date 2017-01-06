package com.schoolpal.db.model;

import java.util.Date;

public class TRoleFunctionExclude {
    private String cRoleId;

    private String cFunctionId;

    private String cCreator;

    private Date cCreateTime;

    public String getcRoleId() {
        return cRoleId;
    }

    public void setcRoleId(String cRoleId) {
        this.cRoleId = cRoleId == null ? null : cRoleId.trim();
    }

    public String getcFunctionId() {
        return cFunctionId;
    }

    public void setcFunctionId(String cFunctionId) {
        this.cFunctionId = cFunctionId == null ? null : cFunctionId.trim();
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