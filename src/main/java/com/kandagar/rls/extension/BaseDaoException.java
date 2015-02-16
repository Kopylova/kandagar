package com.kandagar.rls.extension;

public class BaseDaoException extends RuntimeException {

	private static final long serialVersionUID = -3388606185248189899L;

	public BaseDaoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		//super(message, cause, enableSuppression, writableStackTrace);
		super(message, cause);
	}

	public BaseDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseDaoException(String message) {
		super(message);
	}

	public BaseDaoException(Throwable cause) {
		super(cause);
	}
}
