package com.epam.testapp.exception;

public class NewsServiceException extends Exception {

	/**
	 * This class represents an exception that will be thrown if happens some
	 * kind of error situation in Service layer (including DAO Exception that
	 * were thrown from DAO layer).
	 */
	private static final long serialVersionUID = 1L;

	public NewsServiceException() {
		super();
	}

	public NewsServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NewsServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NewsServiceException(String message) {
		super(message);
	}

	public NewsServiceException(Throwable cause) {
		super(cause);
	}
}
