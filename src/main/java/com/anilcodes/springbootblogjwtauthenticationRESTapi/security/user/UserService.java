package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.login.AuthenticationResponseDTO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User Not Found"));
		return user;
	}
	
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public AuthenticationResponseDTO generateAuthenticationResponse(User user) {
		return new AuthenticationResponseDTO(user);
	}
	
}
