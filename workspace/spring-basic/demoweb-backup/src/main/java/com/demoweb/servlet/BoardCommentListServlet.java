package com.demoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardComment;
import com.demoweb.service.BoardService;

@WebServlet(urlPatterns = { "/board/comment-list.action" })
public class BoardCommentListServlet extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		// --> Filter에서 일괄처리하는 방식으로 변경
		
		//1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(req.getParameter("boardno"));
		
		//2. 요청 처리		
		BoardService boardService = new BoardService();
		List<BoardComment> comments = boardService.findCommentsByBoardNo(boardNo);
		
		//3. JSP에서 읽을 수 있도록 request 객체에 데이터 저장
		req.setAttribute("comments", comments);
		
		//4. JSP로 이동 (forward)
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/board/comments.jsp");
		dispatcher.forward(req, resp);
		
	}
}






