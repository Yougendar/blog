/**
 * 
 */
package com.sugali.blog.Blog.Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugali.blog.Blog.Application.entity.Comment;

/**
 * @author Administrator
 *
 */
public interface CommentRepo extends JpaRepository<Comment,Long> {
	List<Comment> findByPostId(Long postId);

}
