package com.schoolpal.db.model;

public class TRoleFunction {
	private String cRoleId;
	private String cFunctionRootId;
    private Integer cOrderNum;

    public Integer getcOrderNum() {
        return cOrderNum;
    }

    public void setcOrderNum(Integer cOrderNum) {
        this.cOrderNum = cOrderNum;
    }

	public String getcRoleId() {
		return cRoleId;
	}

	public void setcRoleId(String cRoleId) {
		this.cRoleId = cRoleId;
	}

	public String getcFunctionRootId() {
		return cFunctionRootId;
	}

	public void setcFunctionRootId(String cFunctionRootId) {
		this.cFunctionRootId = cFunctionRootId;
	}
}