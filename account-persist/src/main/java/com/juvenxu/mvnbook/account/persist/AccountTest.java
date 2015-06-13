package com.juvenxu.mvnbook.account.persist;

public class AccountTest {

	public static void main(String[] args) throws AccountPersistException {
		AccountPersistService service = new AccountPersistServiceImpl("D:\\Program\\workspace-kepler\\account-persist\\test");
		service.readAccount("a");
	}
}
