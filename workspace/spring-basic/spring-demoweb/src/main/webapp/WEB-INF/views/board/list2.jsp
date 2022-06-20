<%@page import="com.demoweb.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시물 목록</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<style type="text/css">
	a { text-decoration: none; }
	</style>	
</head>
<body>

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
	<div id="pageContainer">		
		<div style="padding-top:25px;text-align:center">
			
			[&nbsp;<a href="/demoweb/board/write.action">글쓰기</a>&nbsp;]
			[&nbsp;<a href="write.action">글쓰기</a>&nbsp;]
				
			<br /><br />
			
			<table border="1" align="center">
				<tr style="background-color:beige;height:25px">
					<th style="width:50px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:150px">작성자</th>
					<th style="width:120px">작성일</th>
					<th style="width:80px">조회수</th>
				</tr>
				<% List<Board> boardList = (List<Board>)request.getAttribute("boardList"); %>
				<% for(Board board : boardList) { %>				
				<tr style="height:25px">
					<td><%= board.getBoardNo() %></td>
					<td style='text-align:left;padding-left:5px'>
					<% if (board.isDeleted()) { // 삭제된 경우 %>
						<span style="color:lightgray"><%= board.getTitle() %> [삭제된 글]</span>
					<% } else { %>
						<a href='detail.action?boardno=<%= board.getBoardNo() %>&pageNo=<%= request.getAttribute("pageNo") %>'>
						<%= board.getTitle() %>
						</a>
					<% } %>
					
					</td>
					<td><%= board.getWriter() %></td>
					<td><%= board.getRegDate() %></td>
					<td><%= board.getReadCount() %></td>
				</tr>
				<% } %>
			</table>
			
			<br><br>
			
			<%= request.getAttribute("pager") %>
			
		</div>
	</div>

</body>
</html>













