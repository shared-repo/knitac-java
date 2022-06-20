package com.demoweb.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.net.URLPermission;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.dto.BoardAttach;
import com.demoweb.service.BoardService;

@WebServlet("/board/download.action") 
public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 요청 정보에서 파일 번호 읽기
		String sAttachNo = req.getParameter("attachno");
		int attachNo = -1;
		try {
			attachNo = Integer.parseInt(sAttachNo);
		} catch (Exception ex) {
			resp.sendRedirect("list.action");
			return;
		}
		
		//2. 서비스 객체에 파일 번호에 해당하는 파일 정보 요청
		BoardService boardService = new BoardService();
		BoardAttach boardAttach = boardService.findBoardAttachByAttachNo(attachNo);		
		
		//3. 다운로드 처리
		//ServletContext : JSP의 application객체와 동일한 객체
		ServletContext application = req.getServletContext();		
		String path = 
			application.getRealPath("/upload-files/" + boardAttach.getSavedFileName());				
				
		//브라우저가 응답 컨텐츠를 다운로드로 처리하도록 정보 설정
		resp.setContentType("application/octet-stream;charset=utf-8");	
		
		//브라우저에게 다운로드하는 파일의 이름을 알려주는 코드 
		resp.addHeader("Content-Disposition", 
				"Attachment;filename=\"" + 
				new String(boardAttach.getUserFileName().getBytes("utf-8"), "ISO-8859-1") + "\"");
		
		FileInputStream fis = new FileInputStream(path); 	//파일을 읽는 도구
		OutputStream fos = resp.getOutputStream();			//브라우저에게 전송하는 도구
		
		while (true) {
			int data = fis.read();  //파일에서 1byte 읽기
			if (data == -1) { //더 이상 읽을 데이터가 없다면 (EOF)
				break;
			}
			fos.write(data); //응답 스트림에 1byte 쓰기
		}
		
		fis.close();
		fos.close();

	}

}
