package com.demoweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.dto.Board;
import com.demoweb.service.BoardService;

@WebServlet(urlPatterns = { "/board/list.action" })
public class BoardListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) { // 로그인하지 않은 경우
			resp.sendRedirect("/demoweb/account/login.action");
			return;
		}		
		
		//1. 요청 데이터 읽기
		//2. 요청 처리	
		BoardService boardService = new BoardService();
		List<Board> boardList = boardService.findAll();
		// System.out.println("data count : " + boardList.size());
		
		//3. JSP에서 사용할 수 있도록 request 객체에 데이터 저장 ( forward 이동인 경우 )
		req.setAttribute("boardList", boardList);
		
		//4. 이동 (forward or redirect)
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
		
	}
}






