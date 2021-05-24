package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedAcessException extends RuntimeException {
	private static final long serialVersionUID = 2000917718903504988L;
	
	public UnauthorizedAcessException(String message) {
		super(message);
	}

}
