package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.login;

import java.io.Serializable;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;

public class AuthenticationResponseDTO implements Serializable{

	private static final long serialVersionUID = -708029843177001403L;
	
	private String token;
	private String email;
	private String roleName;
	private String firstName;
	private String lastName;
	private Boolean isActive;
	
	public AuthenticationResponseDTO() {
	}
	
	public AuthenticationResponseDTO(User user) {
		this.email = user.getEmail();
		this.roleName = user.getRole().getRole();
		this.isActive = user.getIsActive();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
