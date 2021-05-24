package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.dto;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.category.Category;

public class CategoryResponse {

	private Long id;
	private String name;
	private String slug;
	
	public CategoryResponse() {
	}
	
	public CategoryResponse(Category category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
		this.slug = category.getSlug();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
