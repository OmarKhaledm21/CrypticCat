package com.global.crypticcat.exception;

public class MessageNotFoundException extends RuntimeException {
	private static final String message = "Message not found";
	public MessageNotFoundException() {
		super(message);
	}

}
