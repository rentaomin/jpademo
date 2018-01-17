package com.rtm.repository;

public interface MyUserRepository extends  UserBaseRepository{
	
	/**
	 * 查询当前用户的数量
	 * @return
	 */
	long countUserByName(String name);
}
