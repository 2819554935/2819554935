package com.ns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	/**
	重写WebSecurityConfigurerAdapter的configure方法，因为 Spring Security 
	默认开启了所有 CSRF 攻击防御，需要禁用 /eureka 的防御。
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        // 开启认证
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
 

}
