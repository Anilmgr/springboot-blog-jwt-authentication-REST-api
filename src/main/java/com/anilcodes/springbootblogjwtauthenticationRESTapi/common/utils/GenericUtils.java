package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.utils;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.core.context.SecurityContextHolder;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;

public class GenericUtils {

	public static boolean isValidEmail(String email) {
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(email);
	}
	
	public static User getLoggedInUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
}
