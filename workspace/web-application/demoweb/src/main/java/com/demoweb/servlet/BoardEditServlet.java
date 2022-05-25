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

@WebServlet(urlPatterns = { "/board/edit.action" })
public class BoardEditServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) { // 로그인하지 않은 경우
			resp.sendRedirect("/demoweb/account/login.action");
			return;
		}		
		
		//1. 요청 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		if (sBoardNo == null || sBoardNo.length() == 0) { // 잘못된 요청
			resp.sendRedirect("list.action");
			return;
		}
		//System.out.println(sBoardNo);
		int boardNo = Integer.parseInt(sBoardNo); // 문자열 -> 숫자
		
		//2. 요청 처리	
		BoardService boardService = new BoardService();
		Board board = boardService.findByBoardNo(boardNo);
		// System.out.println(board.getTitle() + "/" + board.getWriter());
		if (board == null) { // 해당 번호의 게시글이 없는 경우
			resp.sendRedirect("list.action");
			return;
		}
		
		//3. JSP에서 사용할 수 있도록 request 객체에 데이터 저장 ( forward 이동인 경우 )
		req.setAttribute("board", board);
		
		//4. 이동 (forward or redirect)
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) { // 로그인하지 않은 경우
			resp.sendRedirect("/demoweb/account/login.action");
			return;
		}		
		
		//1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo); // 문자열 -> 숫자
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//2. 요청 처리	
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		
		BoardService boardService = new BoardService();
		boardService.update(board);
		
		//3. 
		//4. 이동
		resp.sendRedirect("detail.action?boardno=" + sBoardNo);
	}
}






