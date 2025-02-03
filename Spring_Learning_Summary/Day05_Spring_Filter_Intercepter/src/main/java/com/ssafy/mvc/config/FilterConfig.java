package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.MyFilter;

@Configuration // 여기는 설정 파일입니다. 라는 어노테이션
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<MyFilter> myfilter() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new MyFilter()); // 어떤 필터
		registrationBean.addUrlPatterns("/hello"); // 어떤 경로
		registrationBean.setOrder(1); // 어떤 순서로..
		
		return registrationBean;
	}
}
