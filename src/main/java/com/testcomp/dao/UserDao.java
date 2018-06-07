package com.testcomp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testcomp.entity.User;

public interface UserDao extends JpaRepository<User, Long> {
	
}
