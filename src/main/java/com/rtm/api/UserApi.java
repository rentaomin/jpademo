package com.rtm.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rtm.domain.User;
import com.rtm.repository.UserRepository;
import com.rtm.service.UserService;

/**
 * 用于测试JPA的增删改查方法
 * @author Dell
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserApi {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 使用service根据id查询用户
	 */
	@RequestMapping(value="/find/{id}")
	public void findUserById(@PathVariable("id") Integer id) {
		User user = userRepository.getOne(id);
		System.out.println("查詢的用戶為："+user);
	}
	
	/**
	 * 保存单个用户
	 */
	@RequestMapping(value="/save")
	public void saveUser() {
		for (int i = 0 ;i < 100;i++ ) {
			User user = new User();
			user.setName("李四"+i);
			user.setPassword("asdqwe"+i);
			user.setBirthday(new Date());
			User save = userRepository.save(user);
			System.out.println("保存用户信息成功"+save);
		}
	}
	
	/**
	 * 根据id删除用户
	 */
	@RequestMapping(value="/delete/{id}")
	public void delUserById(@PathVariable("id") Integer id) {
		userRepository.delete(id);
		System.out.println("删除id为："+id+"的用户");
	}
	
	/**
	 * 查询用户数量
	 */
	@RequestMapping(value="/count")
	public void countUser() {
		long count = userRepository.count();
		System.out.println("一共："+count+"用户");
	}
	
	/**
	 * 删除对象
	 */
	@RequestMapping(value="/del")
	public void delUser() {
		List<User> userList = userRepository.findAll();
		if (userList == null || userList.isEmpty()) {
			System.out.println("没有查询到用户");
		}
		for (User user:userList) {
			if (user.getName().equals("李四5")) {
				System.out.println("删除当前用户信息为："+user);
				 userRepository.delete(user);
			}
		}
	}
	
	/**
	 * 批量新增用户
	 */
	@RequestMapping(value="/bachSave")
	public void bachSaveUser() {
		List<User> userList = new ArrayList<User>();
		for (int i = 0;i<50;i++ ) {
			User u = new User();
			u.setName("马云"+i);
			u.setPassword("ttt"+i);
			u.setBirthday(new Date());
			userList.add(u);
		}
 		List<User> save = userRepository.save(userList);
		System.out.println("一共保存"+save.size()+"用户");
	}
	
	/**
	 * 通过id更新用户信息
	 * @param id
	 */
	@RequestMapping(value="/update/{id}")
	public void updateOneUser(@PathVariable("id") Integer id) {
		User findOne = userRepository.findOne(id);
		System.out.println("更新前的用户为："+findOne);
		findOne.setBirthday(new Date());
		findOne.setName("王柳");
		findOne.setPassword("admin");
		User saveAndFlush = userRepository.saveAndFlush(findOne);
		System.out.println("更新后的用户为："+saveAndFlush);
	}
	
}
