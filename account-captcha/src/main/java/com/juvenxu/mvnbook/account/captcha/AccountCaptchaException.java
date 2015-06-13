package com.juvenxu.mvnbook.account.captcha;

public class AccountCaptchaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountCaptchaException() {}
	
	public AccountCaptchaException(String message) {
		super(message);
	}
	
	public AccountCaptchaException(String message, Throwable e) {
		super(message, e);
	}

}
