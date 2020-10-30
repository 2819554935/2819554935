package com.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *多配置环境
 *application-dev.properties
 *application-test.properties
 *application-prod.properties
 *
 *需要先通过Maven的命令打包 clean install *需要联网*
 *打包后在target下会有一个jar包
 *运行项目并指定运行的配置文件
 *  java -jar 项目名.jar --spring.profiles.active={dev,prod,test}
 *
 *java -jar SpringBoot_01-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
