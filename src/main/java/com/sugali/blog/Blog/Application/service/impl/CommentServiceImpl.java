package com.sugali.blog.Blog.Application.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugali.blog.Blog.Application.dto.CommentDomain;
import com.sugali.blog.Blog.Application.entity.Comment;
import com.sugali.blog.Blog.Application.entity.Post;
import com.sugali.blog.Blog.Application.repository.CommentRepo;
import com.sugali.blog.Blog.Application.repository.PostsRepo;
import com.sugali.blog.Blog.Application.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	PostsRepo postRepo;
	
	@Override
	public CommentDomain createComment(Long postId,CommentDomain commentDomain) {
		
		Comment comment = new Comment();
//		comment.setId(commentDomain.getId());
		comment.setName(commentDomain.getName());
		comment.setEmail(commentDomain.getEmail());
		comment.setBody(commentDomain.getBody());
		
		Post post = postRepo.findById(postId).orElseThrow();
		comment.setPost(post);
		
		Comment savedComment = commentRepo.save(comment);
		CommentDomain newcomment = new CommentDomain();
		newcomment.setId(savedComment.getId());
		newcomment.setName(savedComment.getName());
		newcomment.setEmail(savedComment.getEmail());
		newcomment.setBody(savedComment.getBody());
		return newcomment;
		
		
		
	}
	
	@Override
	public List<CommentDomain> getAllCommentsByPostId(Long postId){
		List<Comment> comment = commentRepo.findByPostId(postId);
		List<CommentDomain> commentDomain = new ArrayList<>();
		commentDomain.addAll((Collection<? extends CommentDomain>)comment.stream().map(c->new CommentDomain(c)).collect(Collectors.toList()));
		return commentDomain;
	}
	
	@Override
	public CommentDomain getCommentById(Long id) {
		Comment comment = commentRepo.findById(id).orElseThrow();
		return new CommentDomain(comment);
 
	}

}
