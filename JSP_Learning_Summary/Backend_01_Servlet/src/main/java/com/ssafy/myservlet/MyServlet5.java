package com.ssafy.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet2")
public class MyServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = response.getWriter();
		
//		writer.write("<html>");
//		writer.write("<head>");
//		writer.write("<title>Hello! SSAFY!</title>");
//		writer.write("</head>");
//		writer.write("<body>");
//		writer.write("<h1>Hello! Servlet!</h1>");
//		writer.write("<p>Hello! SSAFY</p>");
//		writer.write("</body>");
//		writer.write("</html>");
		
		writer.write("""
				<html>
					<head><title>Hell! SSAFY!</title>
					<body>
						<h1>MyServlet5!</h1>
					</body>
				</html>
				""");
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
