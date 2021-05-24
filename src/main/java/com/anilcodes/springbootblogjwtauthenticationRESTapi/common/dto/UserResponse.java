package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.dto;

import java.util.UUID;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;

public class UserResponse {
	
	private UUID id;
	private String email;
	private String roleName;
	private String firstName;
	private String lastName;
	private Boolean isActive;
	
	public UserResponse() {
	}

	public UserResponse(User user) {
		super();
		this.id = user.getUserId();
		this.email = user.getEmail();
		this.roleName = user.getRole().getRole();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.isActive = user.getIsActive();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
