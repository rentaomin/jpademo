package com.rtm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtm.domain.User;
import com.rtm.repository.UserRepository;
import com.rtm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public User findUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
