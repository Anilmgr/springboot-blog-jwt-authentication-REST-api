package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LocaleService {
	
	@Autowired
	private MessageSource messageSource;
	
	
	/**
	 * This method is used to get message form source properties
	 * 
	 * 
	 * @param code
	 * @return
	 */
	public String getMessage(String code) {
		Locale locale = LocaleContextHolder.getLocale();
		return this.messageSource.getMessage(code, null, locale);
	}
}
