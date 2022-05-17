package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/rps-game.action")
// @WebServlet(urlPatterns = "/rps-game.action")
@WebServlet(urlPatterns = { "/rps-game.action" })
public class RpsGameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		String user = req.getParameter("myselection");
		
		
		// 3. 응답 컨텐츠 생산 + 응답
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.write("당신의 선택은 : " + user + " 입니다.");
		
	}
	
}











