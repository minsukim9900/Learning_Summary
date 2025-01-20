package com.ssafy.basic;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//public class HelloServlet extends GenericServlet {
//
//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		
//		// tomcat이 10.0 이하 버전이라면..
//		HttpServletRequest request = (HttpServletRequest) arg0;
//		if(request.getMethod().equals("POST")) {
//			request.setCharacterEncoding("utf-8");
//		}
//		
//		
//	}
//
//
//}

public class HelloServlet1 extends HttpServlet { // HttpServlet => 의미상 추상 클래스

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
