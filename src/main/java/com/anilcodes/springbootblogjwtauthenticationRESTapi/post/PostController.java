package com.anilcodes.springbootblogjwtauthenticationRESTapi.post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.ErrorCollection;
import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
	
	@Autowired 
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<Object> getPosts(@RequestHeader String authorization){
		return postService.getPosts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPostById(@PathVariable("id") Long id, @RequestHeader String authorization){
		return postService.getPostById(id	);
	}
	
	@PostMapping
	public ResponseEntity<Object> addPost(@RequestHeader String authorization, @RequestBody PostRequestDTO postRequestDTO, BindingResult bindingResult, HttpServletRequest request) {
		
		if(bindingResult.hasErrors()) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, ErrorCollection.getErrorMap(bindingResult));
		}
		
		return postService.addPost(postRequestDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePost(@PathVariable("id") Long id, @RequestHeader String authorization, @RequestBody PostRequestDTO postRequestDTO, BindingResult bindingResult, HttpServletRequest request) {
		
		if(bindingResult.hasErrors()) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, ErrorCollection.getErrorMap(bindingResult));
		}
		
		return postService.updatePost(id,postRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePost(@PathVariable("id") Long id, @RequestHeader String authorization) {
		
		return postService.deletePost(id);
	}

}
