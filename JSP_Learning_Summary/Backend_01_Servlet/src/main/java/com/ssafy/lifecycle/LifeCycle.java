package com.ssafy.lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int initCount = 1;
	int doGetCount = 1;
	int destroyCount = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycle() {
    	System.out.println("생성자 호출!");
    }
    
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("init 메서드 호출" + (initCount++));
    }
    
    public void destroy() {
    	System.out.println("destroy 메서드 호출 " + (destroyCount++));
    	System.out.println("끝");
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet 메서드 호출" + (doGetCount++));
		// 화면을 그려줘 라고 하는 것을 만들지 않았다.!
	}

}
