package com.llb.dao;


import com.llb.entity.Role;
import com.llb.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao  {

	User findByUsername(String username);
	List<Role> listByUserId(long id);
}
