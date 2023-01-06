package com.sugali.blog.Blog.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugali.blog.Blog.Application.dto.PostDomain;
import com.sugali.blog.Blog.Application.entity.Post;

public interface PostsRepo extends JpaRepository<Post,Long> {

}
