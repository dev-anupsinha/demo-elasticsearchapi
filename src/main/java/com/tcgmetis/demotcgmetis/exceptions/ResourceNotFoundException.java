package com.tcgmetis.demotcgmetis.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID=100L;

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ResourceNotFoundException(String message) {
		super(message);

	}
	
	

}
