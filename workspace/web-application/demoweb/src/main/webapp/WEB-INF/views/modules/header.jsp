<%@ page import="com.demoweb.dto.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	
    	<% String bgColor = request.getParameter("bg_color"); %>
    	<% if (bgColor != null && bgColor.length() > 0) { %>
		<div id="header" style='background-color:<%= bgColor %>'>
		<% } else { %>
		<div id="header">
		<% } %>
			<div class="title">
                <a href="/demoweb/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <% Member member = // 세션에서 인증 데이터 읽기 : 로그인 여부 확인용 데이터
            	(Member)session.getAttribute("loginuser"); %>            
            <% if (member == null) { // 세션에 데이터 없음 : 로그인하지 않은 경우 %>
            	<a href="/demoweb/account/login.action">로그인</a>
                <a href="/demoweb/account/register.action">회원가입</a>
            <% } else { %>
            	<%= member.getMemberId() %>님 반갑습니다
            	<a href="/demoweb/account/logout.action">로그아웃</a>
            <% } %>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
		</div>