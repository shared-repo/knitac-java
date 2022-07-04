package com.demoweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.demoweb.dto.Member;

public class AuthInterceptor implements HandlerInterceptor {
	
	// 컨트롤러의 메서드 호출 전에 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("Pre Handle");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginuser");
		if (member == null) {
			response.sendRedirect("/demoweb/account/login");
			return false;// false면 컨트롤러 호출 X
		} else {		
			return true; // true면 컨트롤러 호출 O
		}
	}	
	// 컨트롤러의 메서드 호출 후에 처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("Post Handle");
	}
	// View까지 처리된 후에 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("After Completion");
	}

}
