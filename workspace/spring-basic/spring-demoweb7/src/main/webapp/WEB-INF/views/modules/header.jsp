<%@ page import="com.demoweb.dto.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    	<c:choose>
    	<c:when test="${ not empty param.bg_color }">
		<div id="header" style='background-color:${ param.bg_color }'>
		</c:when>
		<c:otherwise>
		<div id="header">
		</c:otherwise>
		</c:choose>
			<div class="title">
                <a href="/demoweb/home">DEMO WEBSITE</a>
            </div>
            <div class="links">            
            <c:choose>
            <c:when test="${ empty loginuser }">                        
            	<a href="/demoweb/account/login">로그인</a>
                <a href="/demoweb/account/register">회원가입</a>
            </c:when>
            <c:otherwise>
            	${ loginuser.memberId }님 반갑습니다
            	<a href="/demoweb/account/logout">로그아웃</a>
            </c:otherwise>
            </c:choose>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="/demoweb/board/list">게시판</a></li>
                </ul>
            </div>
		</div>