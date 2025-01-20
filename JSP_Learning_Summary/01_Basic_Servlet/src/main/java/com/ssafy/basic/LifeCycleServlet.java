package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
        super();
        System.out.println("Constructor call!!!!!!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() call!!!!!!");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init() call!!!!!");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("desroy() call!!!!");
	} 
}
