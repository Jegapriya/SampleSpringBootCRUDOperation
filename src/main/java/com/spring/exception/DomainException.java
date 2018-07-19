package com.spring.exception;

public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public DomainException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public DomainException() {
		super();
	}
}