package com.rtm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rtm.domain.User;

/**
 * 用户基础接口,提供基本的增、删、改、查方法
 * @author Dell
 *
 */
@NoRepositoryBean
public interface UserBaseRepository extends CrudRepository<User, Integer>{
	
	/**
	 * 保存用户
	 */
	@SuppressWarnings("unchecked")
	User save(User entity);
	
	/**
	 * 通过主键查询用户信息
	 */
	User findOne(Integer id);
	
	/**
	 * 查询所有用户信息
	 */
	Iterable<User> findAll();
	
	/**
	 * 通过主键删除用户信息
	 */
	void delete(Integer id);
	
	/**
	 * 删除用户对象
	 */
	void delete(User entity);
}
