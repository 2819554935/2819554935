package com.ns.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.RandomRule;

@Configuration

public class RestTemplateConfig {
	@Bean
	@LoadBalanced 
//	@LoadBalanced 该注解表示应用了ribbon的负载均衡
	protected RestTemplate restTemplate(){
		return new RestTemplate();
	
	}

	@Bean
	protected RandomRule randomRule(){
		return new RandomRule();
		//com.netflix.loadbalancer.RandomRule
	}
	
	
}
