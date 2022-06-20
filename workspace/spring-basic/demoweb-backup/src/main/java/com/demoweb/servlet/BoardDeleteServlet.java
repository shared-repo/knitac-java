package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.service.BoardService;

@WebServlet(urlPatterns = { "/board/delete.action" })
public class BoardDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		// --> Filter에서 일괄처리하는 방식으로 변경
		
		//1. 요청 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		if (sBoardNo == null || sBoardNo.length() == 0) { // 잘못된 요청
			resp.sendRedirect("list.action");
			return;
		}
		//System.out.println(sBoardNo);
		int boardNo = Integer.parseInt(sBoardNo); // 문자열 -> 숫자
		
		// 2. 요청 처리
		BoardService boardService = new BoardService();
		boardService.delete(boardNo);
		
		// 3. JSP에서 사용할 수 있도록 Request 객체에 데이터 저장 ( forward 이동인 경우 )
		// 4. 목록으로 이동
		resp.sendRedirect("list.action");
		
	}
	
}
