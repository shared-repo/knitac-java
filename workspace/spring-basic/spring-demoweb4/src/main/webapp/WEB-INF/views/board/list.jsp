<%@page import="com.demoweb.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
    	 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시물 목록</title>
	<link rel="Stylesheet" href="/demoweb/resources/styles/default.css" />
	<style type="text/css">
	a { text-decoration: none; }
	</style>	
</head>
<body>

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
	<div id="pageContainer">		
		<div style="padding-top:25px;text-align:center">
			
			[&nbsp;<a href="/demoweb/board/write">글쓰기</a>&nbsp;]
			[&nbsp;<a href="write">글쓰기</a>&nbsp;]
				
			<br /><br />
			
			<table border="1" align="center">
				<tr style="background-color:beige;height:25px">
					<th style="width:50px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:150px">작성자</th>
					<th style="width:120px">작성일</th>
					<th style="width:80px">조회수</th>
				</tr>
				<c:forEach var="board" items="${ requestScope.boardList }">
				<tr style="height:25px">
					<td>${ board.boardNo }</td>
					<td style='text-align:left;padding-left:5px'>
					<c:choose>
					<c:when test="${ board.deleted }">
						<span style="color:lightgray">${ board.title } [삭제된 글]</span>
					</c:when>
					<c:otherwise>
						<a href='detail?boardno=${ board.boardNo }&pageNo=${ pageNo }'>
						${ board.title }
						</a>
					</c:otherwise>
					</c:choose>
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.readCount }</td>
				</tr>
				</c:forEach>
			</table>
			
			<br><br>
			
			${ pager }
			
		</div>
	</div>

</body>
</html>













