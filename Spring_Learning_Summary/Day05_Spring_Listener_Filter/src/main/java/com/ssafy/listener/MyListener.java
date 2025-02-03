package com.ssafy.listener;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

public class MyListener implements ServletContextListener {

    public MyListener() {
    }
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("웹 어플리케이션 시작1");
    	ServletContext context = sce.getServletContext();
    	System.out.println(context.getInitParameter("welcome"));
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션 종료1");
    	
    }
	
}
