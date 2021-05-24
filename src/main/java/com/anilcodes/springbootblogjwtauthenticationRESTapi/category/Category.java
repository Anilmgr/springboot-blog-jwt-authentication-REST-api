package com.anilcodes.springbootblogjwtauthenticationRESTapi.category;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;

@Entity
@Table(name="tbl_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable=false, nullable=false)
	private Long id;
	
	@Column(name="name", nullable=false, length=50)
	private String name;
	
	@Column(name="slug", nullable=false, length=50)
	private String slug;
	
	@JoinColumn(name="created_by", nullable=true)
	@OneToOne(fetch = FetchType.EAGER)
	private User createdBy;
	
	@JoinColumn(name="modified_by", nullable=true)
	@OneToOne(fetch = FetchType.EAGER)
	private User modifiedBy;
	
	@Column(name="created_at", nullable=false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="modified_at")
	@UpdateTimestamp
	private LocalDateTime modifiedDate;
	
	public Category() {
	}

	public Category(String name, String slug, User createdBy) {
		super();
		this.name = name;
		this.slug = slug;
		this.createdBy = createdBy;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public Long getId() {
		return id;
	}	
	
}
