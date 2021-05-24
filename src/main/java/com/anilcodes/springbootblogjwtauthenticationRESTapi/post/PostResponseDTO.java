package com.anilcodes.springbootblogjwtauthenticationRESTapi.post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.dto.CategoryResponse;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.dto.TagResponse;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.dto.UserResponse;

public class PostResponseDTO {

	private Long id;
	private String title;
	private String content;
	private String featuredImage;
	private List<CategoryResponse> categories;
	private List<TagResponse> tags;
	private UserResponse createdBy;
	private UserResponse modifiedBy;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public PostResponseDTO() {
	}

	public PostResponseDTO(Post post) {
		super();
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.featuredImage = post.getFeaturedImage();
		this.categories = post.getCategories().stream().map(category->new CategoryResponse(category)).collect(Collectors.toList());
		this.tags = post.getTags().stream().map(tag->new TagResponse(tag)).collect(Collectors.toList());
		this.createdBy = (Objects.nonNull(post.getCreatedBy())) ? new UserResponse(post.getCreatedBy()) : null;
		this.modifiedBy = (Objects.nonNull(post.getModifiedBy())) ? new UserResponse(post.getModifiedBy()) : null;
		this.createdDate = post.getCreatedDate();
		this.modifiedDate = post.getModifiedDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<CategoryResponse> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryResponse> categories) {
		this.categories = categories;
	}

	public List<TagResponse> getTags() {
		return tags;
	}

	public void setTags(List<TagResponse> tags) {
		this.tags = tags;
	}

	public UserResponse getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserResponse createdBy) {
		this.createdBy = createdBy;
	}

	public UserResponse getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserResponse modifiedBy) {
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
	
}
