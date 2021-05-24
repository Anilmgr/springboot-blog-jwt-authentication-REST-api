package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class AuthenticationRequestDTO implements Serializable{

	private static final long serialVersionUID = 1493618283694428326L;

	@NotBlank(message = "${validation.email.blank}")
	private String email;
	
	@NotBlank(message = "${validation.password.blank}")
	private String password;
	
	public AuthenticationRequestDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
