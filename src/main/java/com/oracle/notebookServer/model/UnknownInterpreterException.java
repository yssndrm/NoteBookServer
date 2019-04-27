package com.oracle.notebookServer.model;

@SuppressWarnings("serial")
public class UnknownInterpreterException extends RuntimeException {
	public UnknownInterpreterException() {
		
	}

	public UnknownInterpreterException(String message) {
		super(message);
		
	}

	public UnknownInterpreterException(Throwable cause) {
		super(cause);
		
	}

	public UnknownInterpreterException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UnknownInterpreterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
}
