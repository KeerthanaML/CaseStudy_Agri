package com.user.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends RuntimeException{
	
	public UserAlreadyExistException(String msg) {
		super(msg);
	}

}
