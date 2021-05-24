package com.anilcodes.springbootblogjwtauthenticationRESTapi.common;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.validation.BindingResult;

public class ErrorCollection {
	private static final String DEFAULT_ERROR_MESSAGE = "Wrong data requested";

	private ErrorCollection() {
	}

	public static Map<String, Object> getErrorMap(BindingResult bindingResult) {
		Map<String, Object> errors = new TreeMap<>();
		bindingResult.getFieldErrors()
				.forEach(fieldError -> errors.put(fieldError.getField(),
						fieldError.getDefaultMessage()));
		return errors;
	}

	public static <T> String getError(BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return DEFAULT_ERROR_MESSAGE;
		}
		return null;
	}

}
