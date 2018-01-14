package com.rtm.repository;

import org.springframework.data.repository.CrudRepository;

import com.rtm.domain.User;

public interface UserCrudRepository extends CrudRepository<User, Integer>{
	
	User findUserById(Integer id);
}
