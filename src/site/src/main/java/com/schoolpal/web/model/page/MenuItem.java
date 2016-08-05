package com.schoolpal.web.model.page;

public class MenuItem implements Comparable<MenuItem> {
	
	private String id;
	private String parentId;
	private String text;
	private String action;
	private String icon;
	private int order;
	
	@Override
	public int compareTo(MenuItem item) {
		return Integer.compare(this.getOrder(), item.getOrder());
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
