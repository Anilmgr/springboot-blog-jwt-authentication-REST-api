package com.anilcodes.springbootblogjwtauthenticationRESTapi.post;

import java.util.List;

import javax.validation.constraints.NotBlank;


public class PostRequestDTO {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private String featuredImage;
	
	@NotBlank
	private List<String> categories;
	
	private List<String> tags;
	
	public PostRequestDTO() {
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

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	
}
