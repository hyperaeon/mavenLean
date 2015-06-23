package com.juvenxu.mvnbook.account.service;

public interface AccountService {

	String generateCaptchaKey() throws AccountServiceException;
	
	byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException;
	
	void signUp(SignUpRequest singUpRequest) throws AccountServiceException;
	
	void activate (String activeNumber) throws AccountServiceException;
	
	void login(String id, String password) throws AccountServiceException;
}
