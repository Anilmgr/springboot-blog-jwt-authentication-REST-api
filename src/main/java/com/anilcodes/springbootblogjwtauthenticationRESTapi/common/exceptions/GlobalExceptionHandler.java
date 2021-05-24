package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UnauthorizedAcessException.class)
	public ResponseEntity<Object> unauthorizedAcessException(
			UnauthorizedAcessException ex, WebRequest request){
		 ErrorResponse errorDetails = new ErrorResponse(new Date(),HttpStatus.UNAUTHORIZED.toString(),ex.getMessage(),request.getDescription(false));
		 return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(
			ResourceNotFoundException ex, WebRequest request){
		 ErrorResponse errorDetails = new ErrorResponse(new Date(),HttpStatus.NOT_FOUND.toString(),ex.getMessage(),request.getDescription(false));
		 return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
