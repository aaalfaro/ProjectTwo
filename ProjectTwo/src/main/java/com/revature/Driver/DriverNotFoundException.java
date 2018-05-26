package com.revature.Driver;

public class DriverNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2833482894634404802L;
	
	public DriverNotFoundException() {
		super();	
	}
	public DriverNotFoundException(String message) {
		super(message);
	}
	public DriverNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
}
