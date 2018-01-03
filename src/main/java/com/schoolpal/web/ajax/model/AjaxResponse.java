package com.schoolpal.web.ajax.model;

public class AjaxResponse {
	private int code = 200;
	private String detail = "Ok";
	private Object data = null;

	public AjaxResponse(){
		
	}
	
	public AjaxResponse(int code){
		this.code = code;
	}
	
	public AjaxResponse(int code, String detail){
		this.code = code;
		this.detail = detail;
	}

	public AjaxResponse(int code, String desc, Object data){
		this.code = code;
		this.detail = desc;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
