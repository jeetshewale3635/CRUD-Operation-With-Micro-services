package com.ajit.crud.exception;

public class DeptartmentAlreadyExistsException extends RuntimeException{

	private String message;
	
	public DeptartmentAlreadyExistsException() {
		
	}
	
	public DeptartmentAlreadyExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
	
}
