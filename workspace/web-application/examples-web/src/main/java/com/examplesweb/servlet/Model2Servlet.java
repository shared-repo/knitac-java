package com.examplesweb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/model2.action" })
public class Model2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 요청 데이터 읽기
		// 2. 요청 처리
		
		// 3. JSP에서 사용할 수 있도록 데이터 전달 ( request 객체에 데이터 저장 )
		req.setAttribute("now", new Date());
		
		// 4. 응답컨텐츠 생산 -> JSP에게 요청 ( JSP로 forward )
		RequestDispatcher dispatcher = req.getRequestDispatcher("03.model2.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}





