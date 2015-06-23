package com.juvenxu.mvnbook.account.service;

import com.juvenxu.mvnbook.account.captcha.AccountCaptchaException;

public class AccountServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountServiceException(String message) {
		super(message);
	}

	public AccountServiceException(String message, Exception e) {
		super(message, e);
	}
}
