package com.juvenxu.mvnbook.account.email.duplicate;

public interface AccountEmailService {

	void sendMail(String to, String subject, String htmlText) throws AccountEmailException;
}
