package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;

@Service
public class AuthenticationDTOMapper {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean authenticateUserCredentials(String password, User user) {
		return passwordEncoder.matches(password, user.getPassword());
	}
	
	public void authenticate(String email, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	}
	
}
