package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tbl_role")
public class Role implements GrantedAuthority, Serializable {
	private static final long serialVersionUID = -5146643774465402221L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "role_id", updatable = false, nullable = false, length = 16)
	private UUID roleId;

	@Column(name = "role", nullable = false)
	private String role;

	@Column(name = "description", nullable = false)
	private String description;

	@CreationTimestamp
	@Column(name = "created_date", nullable = true)
	private LocalDateTime createdDate;

	@Column(name = "created_by", nullable = true)
	private UUID createdBy;

	@UpdateTimestamp
	@Column(name = "modified_date", nullable = true)
	private LocalDateTime modifiedDate;

	@Column(name = "modified_by", nullable = true)
	private UUID modifiedBy;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;

	public Role() {
	}

	public Role(String role, String description) {
		this.role = role;
		this.description = description;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public UUID getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UUID modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String getAuthority() {
		return this.role;
	}
}
