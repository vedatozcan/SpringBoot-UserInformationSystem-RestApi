package com.springboot.userinfosys.exception;

import org.springframework.http.HttpStatus;

public class UserAccountException extends RuntimeException{	
	private HttpStatus httpStatus;
	private String message;
	
	public UserAccountException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
}
