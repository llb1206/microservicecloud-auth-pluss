package com.llb.dao;

import com.llb.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao  {

	User findByUsername(String username);
	void save(User user);
	void  updateUser(User user);
}
