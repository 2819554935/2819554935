package com.ns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ns.service.ClientService;

@Controller
public class ClientController {
@Autowired
	private ClientService clientService;

@RequestMapping("/client1")
@ResponseBody
public String clientdemo(){
	//将当前项目启动三次(或以上)分别以不同端口启动9090,9091,9092
	//三个项目的application.name是相同的,以ribbon的负载均衡策略来运行
	return clientService.ribbonDemo();
}

@RequestMapping("/client2")
@ResponseBody
public String demo(){
	
	return clientService.ribbonDemo2();
}

}
