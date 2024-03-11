package com.ajit.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = NoSuchDepartmentExists.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) public @ResponseBody ErrorResponse
	 handleException(NoSuchDepartmentExists ex) {
	 System.out.println("Global exception"); return new
	 ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()); }
	 

}
