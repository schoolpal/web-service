package com.schoolpal.user.model.page;

import java.util.List;

public class Menu implements Comparable<Menu> {
	
	private String id;
	private String text;
	private String icon;
	private List<MenuItem> items;
	private int order;
	
	@Override
	public int compareTo(Menu menu) {
		return Integer.compare(this.getOrder(), menu.getOrder());
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<MenuItem> getItems() {
		return items;
	}
	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
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
