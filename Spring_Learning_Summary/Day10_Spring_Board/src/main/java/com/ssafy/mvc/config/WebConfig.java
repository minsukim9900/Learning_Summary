package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AdminInterceptor;
import com.ssafy.mvc.interceptor.WriteInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	AdminInterceptor adminInterceptor;
	@Autowired
	WriteInterceptor writeInterceptor;
	
	public WebConfig(AdminInterceptor adminInterceptor) {
		this.adminInterceptor = adminInterceptor;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor).addPathPatterns("/users");
		registry.addInterceptor(writeInterceptor).addPathPatterns("/writeform");
	}
	
}
