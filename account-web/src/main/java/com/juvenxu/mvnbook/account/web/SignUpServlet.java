package com.juvenxu.mvnbook.account.web;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.juvenxu.mvnbook.account.model.SignUpRequest;
import com.juvenxu.mvnbook.account.service.AccountService;
import com.juvenxu.mvnbook.account.service.AccountServiceException;

public class SignUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context;

	public void init() throws ServletException {
		super.init();
		context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String captchaKey = request.getParameter("captcha_key");
		String captchaValue = request.getParameter("captcha_value");
		if (isBlank(id) || isBlank(email) || isBlank(name) || isBlank(password)
				|| isBlank(confirmPassword) || isBlank(captchaKey)
				|| isBlank(captchaValue)) {
			response.sendError(400, "Paramete Incomplete");
		}
		AccountService service = (AccountService) context
				.getBean("accountService");
		SignUpRequest signUpRequest = new SignUpRequest();
		signUpRequest.setId(id);
		signUpRequest.setName(name);
		signUpRequest.setEmail(email);
		signUpRequest.setPassword(password);
		signUpRequest.setConfirmPassword(confirmPassword);
		signUpRequest.setCaptchaKey(captchaKey);
		signUpRequest.setCaptchaValue(captchaValue);
		signUpRequest.setActivateServiceUrl(getServletContext()
				.getRealPath("/") + "activate");
		try {
			service.signUp(signUpRequest);
			response.getWriter()
					.print("Account is created, please check your email box for activation link.");
		} catch (AccountServiceException e) {
			response.sendError(400, e.getMessage());
			return;
		} catch (MessagingException e) {
			response.sendError(400, e.getMessage());
			return;
		}
	}

	private boolean isBlank(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

}
