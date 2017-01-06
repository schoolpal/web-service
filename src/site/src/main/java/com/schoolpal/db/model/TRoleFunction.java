package com.schoolpal.db.model;

public class TRoleFunction {
    private String cRoleId;

    private String cFunctionRootId;

    private Integer cOrderNum;

    public String getcRoleId() {
        return cRoleId;
    }

    public void setcRoleId(String cRoleId) {
        this.cRoleId = cRoleId == null ? null : cRoleId.trim();
    }

    public String getcFunctionRootId() {
        return cFunctionRootId;
    }

    public void setcFunctionRootId(String cFunctionRootId) {
        this.cFunctionRootId = cFunctionRootId == null ? null : cFunctionRootId.trim();
    }

    public Integer getcOrderNum() {
        return cOrderNum;
    }

    public void setcOrderNum(Integer cOrderNum) {
        this.cOrderNum = cOrderNum;
    }
}