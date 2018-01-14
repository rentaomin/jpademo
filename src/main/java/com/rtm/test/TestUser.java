package com.rtm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rtm.domain.User;
import com.rtm.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {
	
	@Autowired
	private UserRepository userRepository;
	
	   @Test
	    public void test2(){
	        for (User user:userRepository.findAll()) {
	            System.out.println(user);
	        }
	        System.out.println("search all success");
	    }
}
