package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/account/login.action" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// RequestDispatcher : 요청을 다른 처리기에게 (Servlet or JSP)에게 전달하는 도구
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		dispatcher.forward(req, resp);
		
	}

}






