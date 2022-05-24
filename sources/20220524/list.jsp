<%@page import="java.util.List"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시물 목록</title>
	<link rel="Stylesheet" href="/styles/default.css" />
	<style type="text/css">
	a { text-decoration: none; }
	</style>	
</head>
<body>

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
	<div id="pageContainer">		
		<div style="padding-top:25px;text-align:center">
			
			<input id="write" type="button" value="글쓰기" 
				style="width:300px;height:25px" />
				
			<br /><br />
			
			<table border="1" align="center">
				<tr style="background-color:beige;height:25px">
					<th style="width:50px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:150px">작성자</th>
					<th style="width:120px">작성일</th>
					<th style="width:80px">조회수</th>
				</tr>				
				<tr style="height:25px">
					<td></td>
					<td style='text-align:left;padding-left:5px'></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<br><br>
			
		</div>
	</div>

</body>
</html>













