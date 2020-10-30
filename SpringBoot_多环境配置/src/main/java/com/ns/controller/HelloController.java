package com.ns.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	//@Value("${hello.msg}")
    private String msg;
	
	@RequestMapping("hello")
	@ResponseBody 
	public String ShowHello(){

		return this.msg;
	}
}
