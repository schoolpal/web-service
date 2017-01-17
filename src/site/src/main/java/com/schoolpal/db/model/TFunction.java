package com.schoolpal.db.model;

public class TFunction {
    private String cId;

    private String cRootId;

    private String cParentId;

    private String cNameShort;

    private String cNameLong;

    private String cAction;

    private Integer cWidgetTypeId;

    private Integer cOrderNum;

    private String cIcon;
    
    private String WidgetType;
    
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcRootId() {
        return cRootId;
    }

    public void setcRootId(String cRootId) {
        this.cRootId = cRootId == null ? null : cRootId.trim();
    }

    public String getcParentId() {
        return cParentId;
    }

    public void setcParentId(String cParentId) {
        this.cParentId = cParentId == null ? null : cParentId.trim();
    }

    public String getcNameShort() {
        return cNameShort;
    }

    public void setcNameShort(String cNameShort) {
        this.cNameShort = cNameShort == null ? null : cNameShort.trim();
    }

    public String getcNameLong() {
        return cNameLong;
    }

    public void setcNameLong(String cNameLong) {
        this.cNameLong = cNameLong == null ? null : cNameLong.trim();
    }

    public String getcAction() {
        return cAction;
    }

    public void setcAction(String cAction) {
        this.cAction = cAction == null ? null : cAction.trim();
    }

    public Integer getcWidgetTypeId() {
        return cWidgetTypeId;
    }

    public void setcWidgetTypeId(Integer cWidgetTypeId) {
        this.cWidgetTypeId = cWidgetTypeId;
    }

    public Integer getcOrderNum() {
        return cOrderNum;
    }

    public void setcOrderNum(Integer cOrderNum) {
        this.cOrderNum = cOrderNum;
    }

    public String getcIcon() {
        return cIcon;
    }

    public void setcIcon(String cIcon) {
        this.cIcon = cIcon == null ? null : cIcon.trim();
    }

	public String getWidgetType() {
		return WidgetType;
	}

	public void setWidgetType(String widgetType) {
		WidgetType = widgetType;
	}
}