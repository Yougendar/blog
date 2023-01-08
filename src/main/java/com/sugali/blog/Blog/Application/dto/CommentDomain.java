/**
 * 
 */
package com.sugali.blog.Blog.Application.dto;

import com.sugali.blog.Blog.Application.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDomain {
	private Long id;
	private String name;
	private String email;
	private String body;
	
	
	public CommentDomain(Comment c) {
		this.id = c.getId();
		this.name = c.getName();
		this.email = c.getEmail();
		this.body = c.getBody();
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
