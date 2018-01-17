package com.rtm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.rtm.domain.User;

public interface UserPageRepository extends PagingAndSortingRepository<User, Integer>{
	//自定义接口方法
	long countByName(String name);
}
