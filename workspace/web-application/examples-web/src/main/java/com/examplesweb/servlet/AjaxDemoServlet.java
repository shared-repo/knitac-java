package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/get-time.action" })
public class AjaxDemoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Thread.sleep(5000);// 5초간 실행 중지
		} catch (InterruptedException e) {	} 
		
		PrintWriter out = resp.getWriter();
		
		out.print(new Date().toString());
		
		
	}

	

}









