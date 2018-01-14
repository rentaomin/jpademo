package com.rtm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtm.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
