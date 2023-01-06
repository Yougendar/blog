package com.sugali.blog.Blog.Application.dto;

import com.sugali.blog.Blog.Application.entity.Post;

public class PostDomain {
	
	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param content
	 */
	public PostDomain() {
		
	}
	
	public PostDomain(Post post) {
		this(post,true);
	}
	
	public PostDomain(Post post,boolean done) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.description = post.getDescription();
		this.content = post.getContent();
	}
	
	public PostDomain(Long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	private Long id;
	private String title;
	private String description;
	private String content;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	

}
