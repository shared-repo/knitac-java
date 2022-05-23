package com.demoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.dto.Member;
import com.demoweb.service.AccountService;

@WebServlet(urlPatterns = { "/account/login.action" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// RequestDispatcher : 요청을 다른 처리기에게 (Servlet or JSP)에게 전달하는 도구
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");		
		// System.out.printf("[%s][%s]\n", memberId, passwd);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		
		// 2. 요청 처리 (로그인 처리 - id와 passwd로 데이터베이스에서 데이터 조회 후 세션에 데이터 저장)
		//    서비스 객체에게 데이터 요청
		AccountService accountService = new AccountService();
		Member member2 = accountService.findMemberByIdAndPasswd(member);
		
		if (member2 != null) {
			HttpSession session = req.getSession();	// request객체로부터 세션 가져오기
			session.setAttribute("loginuser", member2); // 세션에 데이터 저장 (로그인 처리)			
		} else {
			// do something
		}
		
		resp.sendRedirect("/demoweb/home.action");
		
	}

}






