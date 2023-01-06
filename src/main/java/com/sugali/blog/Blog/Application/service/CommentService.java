package com.sugali.blog.Blog.Application.service;

import java.util.List;

import com.sugali.blog.Blog.Application.dto.CommentDomain;

public interface CommentService {
	
	CommentDomain createComment(Long postId,CommentDomain commentDomain);
	
	List<CommentDomain> getAllCommentsByPostId(Long postId);
	
	CommentDomain getCommentById(Long id);

}
