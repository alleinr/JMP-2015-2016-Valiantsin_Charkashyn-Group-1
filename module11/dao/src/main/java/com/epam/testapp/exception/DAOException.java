package com.epam.testapp.exception;

public class DAOException extends Exception {

	/**
	 * This class represents an exception that will be thrown if happens some
	 * SQLException or other kind of exception in DAO class.
	 * 
	 * @author Anastasiya_Kulesh
	 */
	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

}
