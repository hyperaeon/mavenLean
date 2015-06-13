package com.juvenxu.mvnbook.account.persist;

public interface AccountPersistService {

	Account creatAccount(Account account) throws AccountPersistException;
	
	Account readAccount(String id) throws AccountPersistException;
	
	Account updateAccount(Account account) throws AccountPersistException;
	
	void deleteAccount(String id) throws AccountPersistException;
}
