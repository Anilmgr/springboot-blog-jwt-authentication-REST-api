package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderUtil {
	
	@Autowired
	private Pbkdf2PasswordEncoder passwordEncoder;
	
	
	/**
	 * This method is use for String encode
	 * 
	 * 
	 * @param rawPassword
	 * @return
	 */
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}
	
	/**
	 * This method is use for password match
	 * 
	 * 
	 * @param rawPassword
	 * @param encodedPassword
	 * @return
	 */
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

}
