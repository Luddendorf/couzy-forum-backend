package com.breeze.summer.utils.exception;

public class CouzyForumException extends RuntimeException {

	/**
	 * A constructor of custom CouzyForumException.
	 *
	 * @param errorMessage text message of error itself.
	 */
    public CouzyForumException(String errorMessage) {
        super(errorMessage);
    }
    
	/**
	 * A constructor of CouzyForumException where we transfer cause of error too.
	 *
	 * @param errorMessage text message of error itself.
	 * @param cause        initial exception that caused the current one.
	 */
    public CouzyForumException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}