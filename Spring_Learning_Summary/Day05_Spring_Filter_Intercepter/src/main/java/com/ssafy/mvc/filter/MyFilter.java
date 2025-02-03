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
//@Order(1) //Order 어노테이션을 통해서 순섲정 가능, 숫자는 정수 범위면 가능, 오름차순
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		System.out.println("서블릿 전1");
		chain.doFilter(request, response);
		System.out.println("서블릿 후1");
		
	}

}
