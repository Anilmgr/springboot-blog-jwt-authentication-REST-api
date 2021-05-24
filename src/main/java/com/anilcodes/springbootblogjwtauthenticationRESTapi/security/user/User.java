package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.role.Role;


@Entity
@Table(name="tbl_user")
public class User implements UserDetails{
	
	private static final long serialVersionUID = 3971755079074051898L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="user_id", updatable = false, nullable= false, length=16)
	private UUID userId;
	
	@Column(name="first_name", nullable = false, length=50)
	private String firstName;
	
	@Column(name="last_name", nullable = false, length=50)
	private String lastName;
	
	@Column(name="email", nullable = false, length=100, unique=true)
	private String email;
	
	@Column(name="password", nullable = false, length=255)
	private String password;
	
	@JoinColumn(name="role_id", nullable = false)
	@OneToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
	private Role role;
	
	@Column(name="last_login_date", nullable = true)
	@CreationTimestamp
	private LocalDateTime lastLoginDate;
	
	@Column(name="loginCount", nullable = true)
	private Long loginCount;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive=true;
	
	@Column(name="created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="modified_at")
	@UpdateTimestamp
	private LocalDateTime modifiedDate; 

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole().toUpperCase()));
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
