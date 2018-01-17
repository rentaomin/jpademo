package com.rtm.api;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rtm.domain.User;
import com.rtm.repository.MyUserRepository;

@Controller
@RequestMapping(value="/userOwner")
public class UserOwnerApi {
	
	@Autowired
	private MyUserRepository myUserRepository;
	
	@RequestMapping("/find")
	public void findUserById() {
		Integer id = 5;
		User user = myUserRepository.findOne(id);
		System.out.println("当前用户信息为："+user);
	}
	
	@RequestMapping("/findAll")
	public void findAll() {
		Iterable<User> userIt = myUserRepository.findAll();
		Iterator<User> it = userIt.iterator();
		while(it.hasNext()) {
			User next = it.next();
			System.out.println("用户信息："+next);
		}
	}
	
	@RequestMapping("/count")
	public void countUser() {
		String name = "张三";
		long num = myUserRepository.countUserByName(name);
		System.out.println("当前用户信息为："+num);
	}
	
	@RequestMapping("/delete")
	public void deleteUserById() {
		Integer id = 5;
		User user = myUserRepository.findOne(id);
		System.out.println("当前用户信息为："+user);
	}
}
