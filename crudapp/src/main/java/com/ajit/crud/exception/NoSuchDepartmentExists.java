package com.ajit.crud.exception;

import lombok.Data;

@Data
public class NoSuchDepartmentExists extends RuntimeException{
	
	private String message;
	
	public NoSuchDepartmentExists() {
		
	}
	
	public NoSuchDepartmentExists(String msg) {
		super(msg);
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NoSuchDepartmentExists [message=" + message + "]";
	}
	
	

}
