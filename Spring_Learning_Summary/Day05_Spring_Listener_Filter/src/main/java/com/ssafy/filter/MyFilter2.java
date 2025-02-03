package com.ssafy.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

public class MyFilter2 extends HttpFilter implements Filter {
       
	
	private FilterConfig fConfig;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		///////////////////////////////서블릿에게 가기 전 코드
		System.out.println("서블릿 전2");
		// 필터는 체이닝 할 수 있어어 doFilter 통해 다음으로 간다.
		// 더이상 갈 필터가 없다면? 서블릿으로 보낸다.
		chain.doFilter(request, response);
		///////////////////////////////////////// 사용자에게 가기전 코드
		System.out.println("서블릿 후 2");
	}
	
	
	// 필터 초기화
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
