package com.demoweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

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
		
		System.out.println(req.getRequestURI()); // 요청 경로 출력 ( 테스트 코드 )
		
		chain.doFilter(request, response);
		
	}

}










