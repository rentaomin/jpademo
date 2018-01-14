package com.rtm.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rtm.domain.User;
import com.rtm.repository.UserCrudRepository;

@Controller
@RequestMapping(value="/userdata")
public class UserDataApi {
	
	@Autowired
	private UserCrudRepository userCrudRepository;
	
	/**
	 * 查询用户数量
	 */
	@RequestMapping(value="/search/{id}")
	public void findUserById(@PathVariable("id") Integer id) {
		User finById = userCrudRepository.findUserById(id);
		System.out.println("查询的用户为："+finById);
	}
	
	/**
	 * 通过多个id查詢多個用户
	 */
	@RequestMapping(value="/findIds")
	public void findUserByIds() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(5);
		ids.add(7);
		 Iterable<User> userList = userCrudRepository.findAll(ids);
		 Iterator<User> it = userList.iterator();
		 while (it.hasNext()) {
			 System.out.println("查询的用户为："+it.next());
		 }
	}

}
