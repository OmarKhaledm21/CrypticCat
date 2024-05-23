package com.global.crypticcat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.global.crypticcat.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MessageNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(MessageNotFoundException e) {
		var errorResponse = ErrorResponse.builder().message(e.getMessage()).code(404).build();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserDoesNotExistException.class)
	public ResponseEntity<ErrorResponse> handleException(UserDoesNotExistException e) {
		var errorResponse = ErrorResponse.builder().message(e.getMessage()).code(404).build();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AuthenticationFailedException.class)
	public ResponseEntity<ErrorResponse> handleException(AuthenticationFailedException e) {
		var errorResponse = ErrorResponse.builder().message(e.getMessage()).code(401).build();
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

}
