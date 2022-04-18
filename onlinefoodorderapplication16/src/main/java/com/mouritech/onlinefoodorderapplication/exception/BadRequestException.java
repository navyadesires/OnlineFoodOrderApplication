package com.mouritech.onlinefoodorderapplication.exception;

public class BadRequestException extends Exception {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -649143029714190977L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(final String message) {
		super(message);
	}
}
