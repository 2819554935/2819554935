package com.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author 方文宇
 * 启动类必须放在controller包的上一级,或者同一级,
 * 注意：不能放在controller的子级下
 */
@EnableEurekaServer//@EnableEurekaServer表示当前是Eureka服务启动类
@SpringBootApplication
public class EurekaApplication {//@SpringBootApplication被该注解标记的为SpringBoot的启动类

	public static void main(String[] args) {
		
		SpringApplication.run(EurekaApplication.class, args);
	}
}
