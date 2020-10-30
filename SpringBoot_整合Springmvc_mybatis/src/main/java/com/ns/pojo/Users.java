package com.ns.pojo;


public class Users extends BaseUser {

	private String username;
	private String password;
	private String age;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password, String age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
	}
	public Users(Integer id,String username, String password, String age) {
		super();
		super.setId(id);
		this.username = username;
		this.password = password;
		this.age = age;
	}
	
}
