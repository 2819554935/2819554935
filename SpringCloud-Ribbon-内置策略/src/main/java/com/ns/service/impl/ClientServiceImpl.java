package com.ns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.RandomRule;
import com.ns.pojo.User;
import com.ns.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
@Autowired
private LoadBalancerClient loadBalancerClient;
@Autowired
private RestTemplate restTemplate;
	
	@Override
	public String ribbonDemo() {
		// TODO Auto-generated method stub
	ServiceInstance si=	loadBalancerClient.choose("Ribbon-Client");
	System.out.println("http://"+si.getHost()+":"+si.getPort());
	//默认使用的策略是轮询1，2，3，1，2，3或3，2，1，3，2，1


		return "";
	}

	@Override
	public String ribbonDemo2() {
		// TODO Auto-generated method stub
   ServiceInstance si=	loadBalancerClient.choose("Ribbon-Client");
   System.out.println("http://"+si.getHost()+":"+si.getPort());
	/**		RestTemplateConfig类中添加
	 	@Bean
	protected RandomRule randomRule(){
		return new RandomRule();
		//com.netflix.loadbalancer.RandomRule
	}
	修改配置Ribbon-Client.ribbon.NFLoadBalancecerRuleClassName=com.netflix.loadbalancer.RandomRule
Ribbon-Client就是application.name的值
	之后就更改了策略了
	发现是随机访问的策略
	 
	 */
		return "";
	}


}
