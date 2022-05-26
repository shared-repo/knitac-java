package com.demoweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Filter 구현
// 1. 클래스 만들기
// 2. Filter 인터페이스 구현 ( 특히 doFilter 메서드 재정의 )
// 3. 등록 : @WebFilter(...) or web.xml

@WebFilter(urlPatterns = { "*.action" })
public class AuthFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//System.out.println(req.getRequestURI()); // 요청 경로 출력 ( 테스트 코드 )
		
		// 로그인 여부 확인 (로그인 안했으면 로그인 화면으로 이동)
		if (req.getRequestURI().contains("/board/")) {
			HttpSession session = req.getSession();
			if (session.getAttribute("loginuser") == null) { // 로그인하지 않은 경우
				resp.sendRedirect("/demoweb/account/login.action");
				return;
			}	
		}
		
		chain.doFilter(request, response);
		
	}

}










