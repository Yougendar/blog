package com.sugali.blog.Blog.Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugali.blog.Blog.Application.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String mail);
	
	Optional<User> findByUsernameOrEmail(String username,String mail);
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String mail);
}
