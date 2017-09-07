package com.schoolpal.db.model;

public class TRank {
    private Integer cId;

    private String cName;

    private Integer cOrderNum;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getcOrderNum() {
        return cOrderNum;
    }

    public void setcOrderNum(Integer cOrderNum) {
        this.cOrderNum = cOrderNum;
    }
}