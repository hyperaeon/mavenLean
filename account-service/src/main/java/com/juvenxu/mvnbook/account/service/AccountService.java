package com.juvenxu.mvnbook.account.service;

import javax.mail.MessagingException;

import com.juvenxu.mvnbook.account.model.SignUpRequest;

public interface AccountService {

	String generateCaptchaKey() throws AccountServiceException;
	
	byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException;
	
	void signUp(SignUpRequest signUpRequest) throws AccountServiceException, MessagingException;
	
	void activate (String activeNumber) throws AccountServiceException;
	
	void login(String id, String password) throws AccountServiceException;
}
