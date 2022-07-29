package com.clearing.houese.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDetailsException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;

	public BankDetailsException() {
		super();
	}

	public BankDetailsException(HttpStatus code, String message) {
		super(message);
		this.statusCode = code;
	}

}
