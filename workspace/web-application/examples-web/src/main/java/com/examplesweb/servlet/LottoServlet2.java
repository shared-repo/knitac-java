package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/select-lotto-numbers.action" })
public class LottoServlet2 extends HttpServlet {

	// doPost : method="post"인 요청일 때 호출되는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String sCnt = req.getParameter("cnt"); // getParameter : 문자열로 반환
		int cnt = Integer.parseInt(sCnt);
		cnt = Math.min(cnt, 10); // 10을 넘지 못하도록 처리
				
		ArrayList<int[]> numbersList = new ArrayList<int[]>();
		for (int i = 0; i < cnt; i++) {
			int[] numbers = selectBasicNumbers();
			numbersList.add(numbers);
		}
		
		resp.setContentType("text/html;charset=utf-8"); // 한글 지원 적용
		
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<head>");
		out.write("<title>로또 당첨 예상번호 목록</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<table width='600' border='1' align='center'>");
		out.write("<caption style='font-size:20pt;text-align:center'>당첨 예상 번호</caption>");
		for (int[] numbers : numbersList) {
			out.write("<tr style='height:50px'>");
			for (int i = 0; i < numbers.length; i++) {
				out.write("<th>");
				out.write(numbers[i] + "");
				out.write("</th>");
			}	
			out.write("</tr>");
		}
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");		
		
	}

	private int[] selectBasicNumbers() {
		int[] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {				
			numbers[i] = (int)(Math.random() * 45) + 1;
			// 중복검사를 위한 반복 ( 0부터 현재 뽑힌 위치 i 이전까지 비교 )
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) { // 현재뽑힌번호 == 이전뽑힌번호 / 중복 발생한 경우
				
					// i--; // 현재 위치의 번호 다시 뽑기
					i = -1; // 처음부터 다시 뽑기
					break;
				}
			}
		}
		return numbers;
	}
	
}








