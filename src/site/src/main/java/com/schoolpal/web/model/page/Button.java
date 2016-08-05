package com.schoolpal.web.model.page;

public class Button implements Comparable<Button> {
	
	private String id;
	private String type;
	private String text;
	private String action;
	private String icon;
	private int order;
	
	@Override
	public int compareTo(Button btn) {
		return Integer.compare(this.getOrder(), btn.getOrder());
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
