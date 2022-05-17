package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/request-process.action" })
public class RequestProcessServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 요청 데이터 읽기 + 사용
		String name = req.getParameter("name"); // <input ... name="name"인 요청 데이터 읽기
		String email = req.getParameter("email");// <input ... name="email"인 요청 데이터 읽기
		
		System.out.printf("[%s][%s]\n", name, email); // 서버의 콘솔에 출력
		
		//2. 응답 컨텐츠 생산 + 응답
		resp.setContentType("text/plain;charset=utf-8"); // 응답 컨텐츠의 종류와 encoding 설정
		PrintWriter out = resp.getWriter();
		out.printf("[%s][%s]", name, email);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}






