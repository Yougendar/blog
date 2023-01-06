package com.sugali.blog.Blog.Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sugali.blog.Blog.Application.dto.CommentDomain;
import com.sugali.blog.Blog.Application.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDomain> createPost(@PathVariable(value="postId")Long postId,@RequestBody CommentDomain commentDomain){
		return new ResponseEntity<>(commentService.createComment(postId, commentDomain),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/posts/{postId}/comments")
	public List<CommentDomain> getAllCommentsById(@PathVariable Long postId){
		return commentService.getAllCommentsByPostId(postId);
	}
	
	@GetMapping("/comments/{commentId}")
	public ResponseEntity<CommentDomain> getCommentById(@PathVariable Long commentId){
		return new ResponseEntity<>(commentService.getCommentById(commentId),HttpStatus.OK);
	}
	

}
