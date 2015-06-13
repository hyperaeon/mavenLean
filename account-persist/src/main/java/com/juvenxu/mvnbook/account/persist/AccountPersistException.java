package com.juvenxu.mvnbook.account.persist;

public class AccountPersistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public AccountPersistException () {
		super();
	}
	
	public AccountPersistException(String message) {
		super(message);
	}
	
	public AccountPersistException (String message, Throwable e) {
		super (message,e);
	}
}
