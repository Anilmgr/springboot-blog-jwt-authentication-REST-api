package com.anilcodes.springbootblogjwtauthenticationRESTapi.post;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.category.Category;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.tag.Tag;

@Entity
@Table(name="tbl_post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable=false, nullable=false)
	private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="content", nullable=false, columnDefinition = "TEXT")
	private String content;
	
	@Column(name="featured_image", nullable=true)
	private String featuredImage;
	
	@ManyToMany(targetEntity = Category.class)
	private List<Category> categories;
	
	@ManyToMany(targetEntity = Tag.class)
	private List<Tag> tags;
	
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
	
	public Post() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
