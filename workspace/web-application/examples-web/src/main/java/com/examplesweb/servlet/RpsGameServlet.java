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
		// 삼항연산자 : 항1 ? 항2 : 항3 --> 항1이 true 이면 항2 선택 아니면 항3 선택
		int iUser = user.equals("scissors") ? 0 : ( user.equals("rock") ? 1 : 2 ) ;
		String kUser = user.equals("scissors") ? "가위" : ( user.equals("rock") ? "바위" : "보" ) ;
		
		//2. 요청 처리 ( 가위 바위 보 게임 실행 )
		int com = (int)(Math.random() * 3); // 0(가위), 1(바위), 2(보)
		
		String result = "";
		if (iUser == com) {
			result = "비겼습니다.";
		} else if ((iUser == 0 && com == 2) ||
				   (iUser == 1 && com == 0) ||
				   (iUser == 2 && com == 1)) {
			result = "이겼습니다.";
		} else {
			result = "졌습니다.";
		}		
		
		// 3. 응답 컨텐츠 생산 + 응답
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.write("당신의 선택은 : <img src='images/" + iUser + ".png' style='width:100px'>");
		out.write("<br>");
		out.write("컴퓨터의 선택은 : <img src='images/" + com + ".png' style='width:100px'>");
		out.write("<br><br>");
		out.write("<h3>결과는 " + result + "</h3>");
		
	}
	
}











