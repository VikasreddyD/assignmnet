package com.clearing.houese.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankDetailsExceptionHandler {

	@ExceptionHandler(value = { BankDetailsException.class })
	public ResponseEntity<Object> handleAPIRequestException(BankDetailsException vechiclesException) {
		HttpStatus httpStatus = vechiclesException.getStatusCode();
		BankDetailsException exception = new BankDetailsException(httpStatus, vechiclesException.getMessage());
		return ResponseEntity.status(httpStatus).body(exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleConstraintViolationExceptions(MethodArgumentNotValidException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input parameters:");
	}

}
