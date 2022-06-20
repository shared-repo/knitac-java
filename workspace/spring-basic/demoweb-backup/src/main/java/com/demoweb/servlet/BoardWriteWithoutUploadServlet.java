package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.dto.Board;
import com.demoweb.service.BoardService;

// @WebServlet(urlPatterns = { "/board/write.action" })
public class BoardWriteWithoutUploadServlet extends HttpServlet {
	// get 요청 처리 ( 여기서는 글쓰기 화면 요청 )
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		// --> Filter에서 일괄처리하는 방식으로 변경
			
		//1. 요청 데이터 읽기
		//2. 요청 처리		
		//3. JSP에서 사용할 수 있도록 데이터 저장 ( forward 이동인 경우 )
		//4. 이동 (forward or redirect)
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/board/write.jsp");
		dispatcher.forward(req, resp);		
	}
	
	// post 요청 처리 ( 여기서는 글쓰기 처리 요청 )
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		// --> Filter에서 일괄처리하는 방식으로 변경
		
		//1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		// System.out.println(title + " / " + writer + " / " + content);
		
		//2. 요청 처리
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardService boardService = new BoardService();
		boardService.writeBoard(board);
		
		//3. JSP에서 사용할 수 있도록 데이터 저장 ( forward 이동인 경우 )
		//4. 이동 (forward or redirect)
		resp.sendRedirect("list.action");
		
	}
}






