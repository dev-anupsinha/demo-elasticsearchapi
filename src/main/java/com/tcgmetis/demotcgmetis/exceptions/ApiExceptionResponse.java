package com.tcgmetis.demotcgmetis.exceptions;

public class ApiExceptionResponse {
	private int statusCode;
	private String errorMessage;
	private String requestedURI;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
