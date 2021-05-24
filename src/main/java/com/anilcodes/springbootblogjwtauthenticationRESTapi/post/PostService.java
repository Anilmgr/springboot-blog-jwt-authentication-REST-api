package com.anilcodes.springbootblogjwtauthenticationRESTapi.post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.category.Category;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.category.CategoryRepository;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.ResponseHandler;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.exceptions.ResourceNotFoundException;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.service.LocaleService;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.utils.GenericUtils;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.User;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.tag.Tag;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.tag.TagRepository;

@Service
public class PostService {
	
	@Autowired
	public PostRepository postRepository;
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	@Autowired
	public TagRepository tagRepository;
	
	@Autowired
	public LocaleService localeService;
	
	
	public ResponseEntity<Object> getPosts(){

		return ResponseHandler.response(HttpStatus.OK, Boolean.TRUE, postRepository.findAll()
				.stream().map(post->new PostResponseDTO(post)).collect(Collectors.toList()));
		
	}
	
	public ResponseEntity<Object> getPostById(Long id){
		
		Post post = postRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException(localeService.getMessage("post.not.found")));	
		
		return ResponseHandler.response(HttpStatus.OK, Boolean.TRUE, new PostResponseDTO(post));
	}
	
	public ResponseEntity<Object> addPost(PostRequestDTO postRequestDTO){

		User user = GenericUtils.getLoggedInUser();		
		List<Tag> tags = getTags(postRequestDTO.getTags());
		List<Category> categories = getCategoriess(postRequestDTO.getCategories());
		
		Post post = new Post();
		post.setTitle(postRequestDTO.getTitle());
		post.setContent(postRequestDTO.getContent());
		post.setCategories(categories);
		post.setTags(tags);
		post.setFeaturedImage(postRequestDTO.getFeaturedImage());
		post.setCreatedBy(user);
		postRepository.save(post);
		
		return ResponseHandler.response(HttpStatus.OK, Boolean.TRUE, localeService.getMessage("post.created"));
	}
	
	public ResponseEntity<Object> updatePost(Long id, PostRequestDTO postRequestDTO){
		
		Post post = postRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException(localeService.getMessage("post.not.found")));
		User user = GenericUtils.getLoggedInUser();		
		List<Tag> tags = getTags(postRequestDTO.getTags());
		List<Category> categories = getCategoriess(postRequestDTO.getCategories());
		
		post.setTitle(postRequestDTO.getTitle());
		post.setContent(postRequestDTO.getContent());
		post.setCategories(categories);
		post.setTags(tags);
		post.setFeaturedImage(postRequestDTO.getFeaturedImage());
		post.setModifiedBy(user);
		postRepository.save(post);
		
		return ResponseHandler.response(HttpStatus.OK, Boolean.TRUE, localeService.getMessage("post.updated"));
	}
	
	public ResponseEntity<Object> deletePost(Long id){
		
		Post post = postRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException(localeService.getMessage("post.not.found")));
		postRepository.delete(post);
		
		return ResponseHandler.response(HttpStatus.OK, Boolean.TRUE, localeService.getMessage("post.deleted"));
	
	}

	private List<Tag> getTags(List<String> tagsStrings){
		User user = GenericUtils.getLoggedInUser();
		List<Tag> tags = new ArrayList<>();
		for (String tagName : tagsStrings) {
			if(!tagRepository.existsByName(tagName))
				tagRepository.save(new Tag(tagName,tagName.toLowerCase(),user));
			tags.add(tagRepository.findByName(tagName));	
		}
		return tags;
	}
	
	private List<Category> getCategoriess(List<String> categoriesStrings){
		User user = GenericUtils.getLoggedInUser();
		List<Category> categories = new ArrayList<>();
		for (String categoryName : categoriesStrings) {
			if(!categoryRepository.existsByName(categoryName))
				categoryRepository.save(new Category(categoryName,categoryName.toLowerCase(),user));
			categories.add(categoryRepository.findByName(categoryName));	
		}
		return categories;
	}
	
}
