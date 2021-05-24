package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.login;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.ErrorCollection;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.ResponseHandler;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.exceptions.UnauthorizedAcessException;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.service.LocaleService;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.constant.UrlConstant;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.factory.JWTTokenFactory;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.UserService;

import io.swagger.annotations.Api;

@Api(value = "Login Controller")
@RestController
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private LocaleService localeService;
	
	@Autowired
	private AuthenticationDTOMapper  authenticationDTOMapper;
	
	@Autowired
	private JWTTokenFactory jwtTokenFactory;
	
	@PostMapping(UrlConstant.LOGIN)
	public ResponseEntity<Object> login(@Valid @RequestBody AuthenticationRequestDTO authenticationRequestDTO,
			BindingResult bindingResult, HttpServletRequest request){
		if (bindingResult.hasErrors()) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, ErrorCollection.getErrorMap(bindingResult));
		}
		
		User user = userService.findByEmail(authenticationRequestDTO.getEmail())
				.orElseThrow(()->new UnauthorizedAcessException(localeService.getMessage("invalid.credential")));
	
		boolean isValidCredentials = authenticationDTOMapper
				.authenticateUserCredentials(authenticationRequestDTO.getPassword(), user);
		
		if (!isValidCredentials) {
			throw new UnauthorizedAcessException(localeService.getMessage("invalid.credential"));
		}
		
		if (!user.getIsActive()) {
			throw new UnauthorizedAcessException(localeService.getMessage("user.inactive"));
		}
	
		AuthenticationResponseDTO authenticationResponseDTO = userService.generateAuthenticationResponse(user);
		String token = jwtTokenFactory.createToken(authenticationRequestDTO.getEmail());
		authenticationResponseDTO.setToken(token);
		return ResponseHandler.response(HttpStatus.OK, true, authenticationResponseDTO);
	}

}
