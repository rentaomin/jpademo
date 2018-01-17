package com.rtm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rtm.domain.User;
import com.rtm.repository.UserPageRepository;

@Controller
@RequestMapping(value="/userpage")
public class UserPageApi {
	
	@Autowired
	private UserPageRepository userPageRepository;
	
	/**
	 * 分页查询数据
	 */
	@RequestMapping("/list")
	public void pageUserList() {
		//1 页数 20,：一页查询的数量
		int pageNum = 1;
		int pageSize = 20;
		Pageable pageable = new PageRequest(pageNum, pageSize);
		Page<User> allUserListPage = userPageRepository.findAll(pageable);
		if (allUserListPage != null) {
			int size = allUserListPage.getSize();
			System.out.println("size当前共有："+size+"数据");
			int totalPages = allUserListPage.getTotalPages();
			System.out.println("totalPages共有："+totalPages);
			long totalElements = allUserListPage.getTotalElements();
			System.out.println("totalElements共有："+totalElements);
			int number = allUserListPage.getNumber();
			System.out.println("number为："+number);
			List<User> content = allUserListPage.getContent();
			for(User user : content) {
				System.out.println("用户信息为："+user);
			}
		}
	}
	
	/**
	 * 自定义查询方法
	 */
	@RequestMapping("/count")
	public void countUserByName() {
		long num = userPageRepository.countByName("张三");
		System.out.println("张三共有："+num);
	}
	
	
	/**
	 * 分页查询数据根据指定属性排序
	 */
	@RequestMapping("/order")
	public void pageUserListOrder() {
		//1 页数 20,：一页查询的数量
		int pageNum = 1;
		int pageSize = 20;
		//默认为ASC升序
		Direction direction  = Direction.DESC;
		//设置排序的属性
		String properties = "id";
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, direction, properties);
		Page<User> allUserListPage = userPageRepository.findAll(pageRequest);
		if (allUserListPage != null) {
			int size = allUserListPage.getSize();
			System.out.println("每页数据为："+size+"条数据");
			int totalPages = allUserListPage.getTotalPages();
			System.out.println("共有："+totalPages+" 页");
			long totalElements = allUserListPage.getTotalElements();
			System.out.println("共有："+totalElements+" 条数据");
			int number = allUserListPage.getNumber();
			System.out.println("第："+number+"页");
			List<User> content = allUserListPage.getContent();
			for(User user : content) {
				System.out.println("用户信息为："+user);
			}
		}
	}

}
