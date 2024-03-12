package com.ajit.crud.exception;

import lombok.Data;

@Data
public class UsernameNotFoundException extends RuntimeException {

	private String message;

	public UsernameNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public UsernameNotFoundException() {
		
	}
	
}
