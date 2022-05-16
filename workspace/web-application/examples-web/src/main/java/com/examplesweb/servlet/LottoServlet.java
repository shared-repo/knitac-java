package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lotto.abc" })
public class LottoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//int[] numbers = { 32, 9, 17, 23, 4, 41 };
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
		
		resp.setContentType("text/plain;charset=utf-8"); // 한글 지원 적용
		
		PrintWriter out = resp.getWriter();
		// out.write("[SELECTED NUMBERS] : ");
		out.write("[선택된 번호] : ");
		for (int i = 0; i < numbers.length; i++) {
			// out.write(numbers[i] + "");
			out.write(String.format("[%2d]", numbers[i]));
		}
		
	}
	
}








