package com.ssafy.mvc.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//단점 : 경로를 지정할 수 없다. 모든 요청에 대해서 이 필터가 작동한다.
//@Component
//@Order(2)
public class MyFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		System.out.println("서블릿 전2");
		chain.doFilter(request, response);
		System.out.println("서블릿 후2");
		
	}

}
