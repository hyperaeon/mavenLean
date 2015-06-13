package com.juvenxu.mvnbook.account.email.duplicate;

public class AccountEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountEmailException() {
		super();
	}

	public AccountEmailException(String msg) {
		super(msg);
	}

	public AccountEmailException(String msg, Throwable e) {
		super(msg, e);
	}
}
