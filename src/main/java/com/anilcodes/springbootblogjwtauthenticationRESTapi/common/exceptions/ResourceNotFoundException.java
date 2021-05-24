package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2646748743777174575L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
