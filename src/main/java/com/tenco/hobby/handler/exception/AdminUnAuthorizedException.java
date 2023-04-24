package com.tenco.hobby.handler.exception;

import org.springframework.http.HttpStatus;

public class AdminUnAuthorizedException extends UnAuthorizedException{
	public AdminUnAuthorizedException(String message, HttpStatus status) {
		super(message, status);
	}
}
