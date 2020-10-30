package com.ns;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
以往连接数据库都是在spring或者mybatis的配置文件中配置的,然而
现在没有这种配置文件，所以
现在使用SpringBoot都是将配置信息添加在application.properties中
所以添加配置文件application.properties全局配置文件





 */
@SpringBootApplication
@MapperScan("com.ns.mapper") //扫描mybatis的mapper接口
public class App {
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
}
