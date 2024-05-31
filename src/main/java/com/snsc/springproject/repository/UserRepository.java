package com.snsc.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snsc.springproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String un, String pw);
	User findByUsername(String un);


}
