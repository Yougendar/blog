package com.sugali.blog.Blog.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sugali.blog.Blog.Application.constants.Constants;
import com.sugali.blog.Blog.Application.dto.PostDomain;
import com.sugali.blog.Blog.Application.dto.PostResponseDomain;
import com.sugali.blog.Blog.Application.service.PostService;


@RestController
public class PostController {
	private PostService postService;
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	
	@GetMapping("api/allposts")
	public PostResponseDomain getAllPosts(@RequestParam(value="pageNo",defaultValue=Constants.DEFAULT_PAGE_NO,required=false)int pageNo,
			                            @RequestParam(value="pageSize", defaultValue=Constants.DEFAULT_PAGE_SIZE,required=false)int pageSize,
			                            @RequestParam(value="sortBy",defaultValue=Constants.DEFAULT_SORT_BY,required=false)String sortBy,
			                            @RequestParam(value="sortDir",defaultValue=Constants.DEFAULT_SORT_DIR,required=false)String sortDir){
		return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
	}
	
	@GetMapping("api/post/{id}")
	public PostDomain getPostById(@PathVariable Long id){
		return postService.getPostById(id);
	}
	
	@PostMapping("/api/post")
	public ResponseEntity<PostDomain> createPost(@RequestBody PostDomain postDomain) {
		return new ResponseEntity<>(postService.createPost(postDomain),HttpStatus.CREATED);
	}
	
	@PutMapping("/api/post/update/{id}")
	public PostDomain updatePost(@RequestBody PostDomain post,@PathVariable Long id) {
		return postService.updatePost(post,id);
	}
	
	@DeleteMapping("api/post/delete/{id}")
	public void deletePost(@PathVariable Long id) {
		postService.deletePost(id);
	}

}
