package com.juvenxu.mvnbook.account.model;

public class SignUpRequest {

	private String id;
	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	private String captchaKey;
	private String captchaValue;
	private String activateServiceUrl;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the activateServiceUrl
	 */
	public String getActivateServiceUrl() {
		return activateServiceUrl;
	}

	/**
	 * @param activateServiceUrl
	 *            the activateServiceUrl to set
	 */
	public void setActivateServiceUrl(String activateServiceUrl) {
		this.activateServiceUrl = activateServiceUrl;
	}

	/**
	 * @return the captchaKey
	 */
	public String getCaptchaKey() {
		return captchaKey;
	}

	/**
	 * @param captchaKey the captchaKey to set
	 */
	public void setCaptchaKey(String captchaKey) {
		this.captchaKey = captchaKey;
	}

	/**
	 * @return the captchaValue
	 */
	public String getCaptchaValue() {
		return captchaValue;
	}

	/**
	 * @param captchaValue the captchaValue to set
	 */
	public void setCaptchaValue(String captchaValue) {
		this.captchaValue = captchaValue;
	}

}
