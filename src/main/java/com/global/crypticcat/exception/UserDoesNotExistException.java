package com.global.crypticcat.exception;

public class UserDoesNotExistException extends RuntimeException {
	private final static String message = "User does not exist";
	public UserDoesNotExistException() {
		super(message);
	}
}
