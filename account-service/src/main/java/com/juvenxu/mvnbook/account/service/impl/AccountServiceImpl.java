package com.juvenxu.mvnbook.account.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import com.juvenxu.mvnbook.account.captcha.AccountCaptchaException;
import com.juvenxu.mvnbook.account.captcha.AccountCaptchaService;
import com.juvenxu.mvnbook.account.captcha.RandomGenerator;
import com.juvenxu.mvnbook.account.email.AccountEmailService;
import com.juvenxu.mvnbook.account.email.duplicate.AccountEmailException;
import com.juvenxu.mvnbook.account.model.SignUpRequest;
import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.persist.AccountPersistException;
import com.juvenxu.mvnbook.account.persist.AccountPersistService;
import com.juvenxu.mvnbook.account.service.AccountService;
import com.juvenxu.mvnbook.account.service.AccountServiceException;

public class AccountServiceImpl implements AccountService {

	private AccountPersistService accountPersistService;

	private AccountEmailService accountEmailService;

	private AccountCaptchaService accountCaptchaService;

	private Map<String, String> activationMap = new HashMap<String, String>();

	public String generateCaptchaKey() throws AccountServiceException {
		return accountCaptchaService.generateCaptchaKey();
	}

	public byte[] generateCaptchaImage(String captchaKey)
			throws AccountServiceException {
		try {
			return accountCaptchaService.generateCaptchaImage(captchaKey);
		} catch (AccountCaptchaException e) {
			throw new AccountServiceException(
					"Unable to generate Captcha Image.", e);
		}
	}

	public void signUp(SignUpRequest signUpRequest)
			throws AccountServiceException, MessagingException {
		try {
			if (!signUpRequest.getPassword().equals(
					signUpRequest.getConfirmPassword())) {
				throw new AccountServiceException("2 passwords do not match.");
			}
			if (!accountCaptchaService.validateCaptchaImage(
					signUpRequest.getCaptchaKey(),
					signUpRequest.getCaptchaValue())) {
				throw new AccountServiceException("Incorrect Captcha.");
			}
			Account account = new Account();
			account.setId(signUpRequest.getId());
			account.setEmail(signUpRequest.getEmail());
			account.setName(signUpRequest.getName());
			account.setPassword(signUpRequest.getPassword());
			account.setActivated(false);

			accountPersistService.creatAccount(account);

			String activationId = RandomGenerator.getRandomString();

			activationMap.put(activationId, account.getId());
			String link = signUpRequest.getActivateServiceUrl().endsWith("/") ? signUpRequest
					.getActivateServiceUrl() + activationId
					: signUpRequest.getActivateServiceUrl() + "?key="
							+ activationId;
			accountEmailService.sendMail(account.getEmail(),
					"Please Activate Your Account", link);
		} catch (AccountCaptchaException e) {
			throw new AccountServiceException("Unable to validate captcha.", e);
		} catch (AccountPersistException e) {
			throw new AccountServiceException("Unable to create account.", e);
		} catch (MessagingException e) {
			throw new AccountServiceException(
					"Unable to send activation mail.", e);
		}
	}

	public void activate(String activeNumber) throws AccountServiceException {
		String accountId = activationMap.get(activeNumber);
		if (accountId == null) {
			throw new AccountServiceException("Invalid account activation ID");
		}
		try {
			Account account = accountPersistService.readAccount(accountId);
			account.setActivated(true);
			accountPersistService.updateAccount(account);
		} catch (AccountPersistException e) {
			throw new AccountServiceException("Unable to activate account.");
		}
	}

	public void login(String id, String password)
			throws AccountServiceException {
		try {
			Account account = accountPersistService.readAccount(id);
			if (account == null) {
				throw new AccountServiceException("Account does not exist.");
			}
			if (!account.isActivated()) {
				throw new AccountServiceException("Account is disable.");
			}
			if (!account.getPassword().equals(account.getPassword())) {
				throw new AccountServiceException("Incorrect password.");
			}
		} catch (AccountPersistException e) {
			throw new AccountServiceException("Unable to log in.", e);
		}
	}

	/**
	 * @return the accountPersistService
	 */
	public AccountPersistService getAccountPersistService() {
		return accountPersistService;
	}

	/**
	 * @param accountPersistService
	 *            the accountPersistService to set
	 */
	public void setAccountPersistService(
			AccountPersistService accountPersistService) {
		this.accountPersistService = accountPersistService;
	}

	/**
	 * @return the accountEmailService
	 */
	public AccountEmailService getAccountEmailService() {
		return accountEmailService;
	}

	/**
	 * @param accountEmailService
	 *            the accountEmailService to set
	 */
	public void setAccountEmailService(AccountEmailService accountEmailService) {
		this.accountEmailService = accountEmailService;
	}

	/**
	 * @return the accountCaptchaService
	 */
	public AccountCaptchaService getAccountCaptchaService() {
		return accountCaptchaService;
	}

	/**
	 * @param accountCaptchaService
	 *            the accountCaptchaService to set
	 */
	public void setAccountCaptchaService(
			AccountCaptchaService accountCaptchaService) {
		this.accountCaptchaService = accountCaptchaService;
	}

}
