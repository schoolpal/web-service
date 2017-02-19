package com.schoolpal.ajax;

public class AjaxResponse {
	private int code = 200;
	private Object data = null;
	private String detail = "Ok";
	
	public AjaxResponse(){
		
	}
	
	public AjaxResponse(int code){
		this.code = code;
	}
	
	public AjaxResponse(int code, String detail){
		this.code = code;
		this.detail = detail;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
