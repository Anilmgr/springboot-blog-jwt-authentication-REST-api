package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.dto;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.tag.Tag;

public class TagResponse {

	private Long id;
	private String name;
	private String slug;
	
	public TagResponse() {
	}
	
	public TagResponse(Tag tag) {
		super();
		this.id = tag.getId();
		this.name = tag.getName();
		this.slug = tag.getSlug();
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
