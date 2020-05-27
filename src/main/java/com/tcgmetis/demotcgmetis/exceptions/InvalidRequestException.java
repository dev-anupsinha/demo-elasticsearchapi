package com.tcgmetis.demotcgmetis.exceptions;

public class InvalidRequestException extends RuntimeException{
	
	private static final long serialVersionUID=100L;

	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);

	}

	public InvalidRequestException(String message) {
		super(message);

	}
	
	

}
