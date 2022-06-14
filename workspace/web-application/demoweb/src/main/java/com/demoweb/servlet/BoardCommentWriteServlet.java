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

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardComment;
import com.demoweb.service.BoardService;

@WebServlet(urlPatterns = { "/board/comment-write.action" })
public class BoardCommentWriteServlet extends HttpServlet {
		
	// post 요청 처리 ( 여기서는 댓글쓰기 처리 요청 )
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		// --> Filter에서 일괄처리하는 방식으로 변경
		
		//1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(req.getParameter("boardno"));
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		System.out.println(boardNo + " / " + writer + " / " + content);
		
		//2. 요청 처리
		BoardComment comment = new BoardComment();
		comment.setBoardNo(boardNo);
		comment.setWriter(writer);
		comment.setContent(content);
		
		BoardService boardService = new BoardService();
		// boardService.writeBoardComment(comment);
		
		//3. 응답
		PrintWriter out = resp.getWriter();
		out.print("success");
		
	}
}






