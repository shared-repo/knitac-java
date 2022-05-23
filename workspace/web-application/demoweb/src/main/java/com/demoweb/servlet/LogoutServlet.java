package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/account/logout.action" })
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 1. 요청 데이터 읽기
		// 2. 요청 처리 (로그아웃 처리 : 세션에서 데이터 제거)
		HttpSession session = req.getSession();
		session.removeAttribute("loginuser"); // 지정된 이름의 데이터만 제거
		// session.invalidate(); // 세션 전체를 제거 (모든 세션 데이터 삭제)
		
		// 3. JSP에서 사용할 수 있도록 Request 객체에 데이터 저장 (redirect인 경우 불필요)
		// 4. 홈으로 이동 
		resp.sendRedirect("/demoweb/home.action");
		
	}
	
}
