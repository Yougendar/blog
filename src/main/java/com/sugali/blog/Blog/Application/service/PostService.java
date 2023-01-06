package com.sugali.blog.Blog.Application.service;

import com.sugali.blog.Blog.Application.dto.PostDomain;
import com.sugali.blog.Blog.Application.dto.PostResponseDomain;

public interface PostService {
	
	PostDomain createPost(PostDomain post);

	PostResponseDomain getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir);
	
	PostDomain getPostById(Long id);
	
	PostDomain updatePost(PostDomain post,Long id);
	
	void deletePost(Long id);
		
	

}
