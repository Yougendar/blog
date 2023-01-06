package com.sugali.blog.Blog.Application.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sugali.blog.Blog.Application.dto.PostDomain;
import com.sugali.blog.Blog.Application.dto.PostResponseDomain;
import com.sugali.blog.Blog.Application.entity.Post;
import com.sugali.blog.Blog.Application.exception.ResourceNotFoundException;
import com.sugali.blog.Blog.Application.repository.PostsRepo;
import com.sugali.blog.Blog.Application.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired PostsRepo postRepo;
	
	@Override
	public PostDomain createPost(PostDomain postdto) {
		Post post = new Post();
		post.setTitle(postdto.getTitle());
		post.setDescription(postdto.getDescription());
		post.setContent(postdto.getContent());
		
		Post savedPost = postRepo.save(post);
		
		PostDomain postResponseDomain = new PostDomain();
		postResponseDomain.setId(savedPost.getId());
		postResponseDomain.setTitle(savedPost.getTitle());
		postResponseDomain.setDescription(savedPost.getDescription());
		postResponseDomain.setContent(savedPost.getContent());
		
		return postResponseDomain;
	}
	
	@Override
	public PostResponseDomain getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir){
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():
			        Sort.by(sortBy).descending();
		
//		Create Instance of Pageable
		PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Post> posts = postRepo.findAll(pageable);
		List<Post> allPosts = posts.getContent();
		List<PostDomain> postdto=new ArrayList<>(); 
		postdto.addAll((Collection<? extends PostDomain>)allPosts.stream().map(ele->new PostDomain(ele.getId(),ele.getTitle(),ele.getDescription(),ele.getContent()) ).collect(Collectors.toList()));
		PostResponseDomain postResponseList = new PostResponseDomain();
		postResponseList.setContent(postdto);
		postResponseList.setPageNo(posts.getNumber());
		postResponseList.setPageSize(posts.getSize());
		postResponseList.setTotalElements(posts.getTotalElements());
		postResponseList.setTotalPages(posts.getTotalPages());
		postResponseList.setLast(posts.isLast());
		return postResponseList;
		
	}

	@Override
	public PostDomain getPostById(Long id) {
		Post saved = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		PostDomain savedPostDomain = new PostDomain(saved);
		return savedPostDomain;
	}
	
	@Override
	public PostDomain updatePost(PostDomain post,Long id) {
		Post saved = postRepo.findById(id).orElseThrow();
		if(post.getTitle()!=null && !post.getTitle().isEmpty())
			saved.setTitle(post.getTitle());
		if(post.getDescription()!=null && !post.getDescription().isEmpty())
			saved.setDescription(post.getDescription());
		if(post.getContent()!=null && !post.getContent().isEmpty())
			saved.setContent(post.getContent());
		Post finalUpdatedPost = postRepo.save(saved);
		
		PostDomain savedPost = new PostDomain(finalUpdatedPost);

		return savedPost;
		
		
	}
	
	@Override
	public void deletePost(Long id) {
		Post saved = postRepo.findById(id).orElseThrow();
		postRepo.delete(saved);
	}
}
