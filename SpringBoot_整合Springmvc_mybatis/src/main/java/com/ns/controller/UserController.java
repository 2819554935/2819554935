package com.ns.controller;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ns.pojo.Users;
import com.ns.service.IUserService;
import com.ns.utils.ResultJson;

/**
springboot+ springmvc +rest
springboot默认是配置好hiddenHttpMethodfilter的
只要添加属性_method=PUT、DELETE就行
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userServiceimpl;
	
	/**
	 * 显示add页面
	 */
	@RequestMapping("/add")
	public String showUser(){
		System.out.println("---------------------------");
		return "add";
		
		
	}
	
	/**
	 * 
	添加User
	 */
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String addUser(String username,String password,String age){
		System.out.println("-添加-------------------------");
		userServiceimpl.addUser(username,password,age);
			return "index";
		
		
	}
	/**
	 * 
	 * 根据id修改User
	 */
	@RequestMapping("update")
	public String updateUser(Integer id,String username,String passwrod,String age){
		System.out.println("-修改--------------------------");
		userServiceimpl.updateUser(id,username,passwrod,age);
		return "add";
		
	}
	/**
	 *查询所有UserList
	 */
	@RequestMapping("users")
	public String selectUserAll(Model model){
		System.out.println("-查询users--------------------------");

	List<Users> users=userServiceimpl.selectUserAll();
	System.out.println(users.size());
	model.addAttribute("users", users);

	return "users";
	}
	/**
	 * 
	 * 查询初始化User方式1
	 */
	@RequestMapping(value={"/user/{id}"})
	public String selectByidUser(@PathVariable(value="id",required=false) Integer id,Model model){
		//@PathVariable(value="id",required=false) Integer id
		//加了这个注解只有两种情况要么就是为了解析{id}而存在,要么就不存在
		//所以就只能再加一个方法了
		System.out.println(id);

		Users user=userServiceimpl.selectByidUser(id);
		model.addAttribute("user", user);
		return "user";
	}
	/**
	 * 
	 * 查询初始化User方式2
	 */
	@RequestMapping(value={"/user"})
	public String selectByidUser2( Integer id,Model model){

		System.out.println(id);

		Users user=userServiceimpl.selectByidUser(id);
		model.addAttribute("user", user);
		return "user";
	}
	
	/**
	 * 修改用户信息
	 * 
	 * 
	 * @PutMapping使用效果与
	 * method=RequestMethod.PUT一样
	 * 
	 */
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable Integer id,String username,String password,String age,Model model){
System.out.println("--修改--------------------------");
		System.out.println(id);
        userServiceimpl.updateUser(id, username, password, age);
		return "redirect:/users";
	}
	
	
	/**
	 * 
	 删除用户
	 */
	@DeleteMapping(value="/user/{id}")
	@ResponseBody
	public ResultJson deleteUser(@PathVariable Integer id,Model model){
System.out.println("--ajax删除--------------------------");
        ResultJson json=new ResultJson();
        try {
            userServiceimpl.delete(id);
            json.setSuccess(true);
            
		} catch (Exception e) {
			// TODO: handle exception
			json.setMessage(e.getMessage());
		}
		System.out.println(id);
		
		return json;
		
	}
	

}
