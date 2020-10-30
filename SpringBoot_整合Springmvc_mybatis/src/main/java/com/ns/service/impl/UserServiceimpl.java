package com.ns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ns.mapper.UserMapper;
import com.ns.pojo.Users;
import com.ns.service.IUserService;

@Service
@Transactional
public class UserServiceimpl implements IUserService {

	@Autowired
	private UserMapper userMapper;


	@Override
	public void addUser(String username, String password, String age) {
		// TODO Auto-generated method stub
		Users user=new Users(username,password,age);
		try {
		if(user!=null){
		System.out.println(username);
		userMapper.insertUser(user);
		}
		} catch (Exception e) {
		
			throw new RuntimeException("user为空");
		
		}
		
		
	}


	public void updateUser(Integer id,String username, String password, String age) {
		// TODO Auto-generated method stub
		
		Users user=new Users(id,username,password,age);
		if(user!=null){
			userMapper.updateUser(user);
		}
	}
	
	public Users selectByidUser(Integer id){
		
		return userMapper.selectByidUser(id);
	}
	
	public List<Users> selectUserAll(){
		
		return userMapper.selectUserAll();
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
	int ret=userMapper.deleteByidUser(id);
	if(ret<=0){
		throw new RuntimeException("删除失败"+id);
	}
		
	}
}
