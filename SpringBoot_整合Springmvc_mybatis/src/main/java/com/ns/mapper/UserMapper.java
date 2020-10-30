package com.ns.mapper;

import java.util.List;

import com.ns.pojo.Users;

public interface UserMapper {

	void insertUser(Users user);

	void updateUser(Users user);

	Users selectByidUser(Integer id);

	List<Users> selectUserAll();

	int deleteByidUser(Integer id);
	
}
