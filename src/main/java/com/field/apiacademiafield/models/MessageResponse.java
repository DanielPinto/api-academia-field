package com.field.apiacademiafield.models;

public class MessageResponse {

	private String code;
	private String message;
	private Object object;
	
	
	public MessageResponse(String error, String message, Object object) {
		super();
		this.code = error;
		this.message = message;
		this.object = object;
	}
	
	
	
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



	public Object getObject() {
		return object;
	}



	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
