package com.ns.service;

import java.util.List;

import com.ns.pojo.Users;



public interface IUserService {


	void addUser(String username, String password, String age);

	void updateUser(Integer id, String username, String passwrod, String age);

	Users selectByidUser(Integer id);
	
	List<Users> selectUserAll();

	void delete(Integer id);
}
