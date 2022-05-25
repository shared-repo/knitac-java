<%@page import="com.demoweb.dto.Member"%>
<%@page import="com.demoweb.dto.Board"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>

	<meta charset="utf-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />

</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시글 내용</div>
		        <% Board board = (Board)request.getAttribute("board"); %>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td><%= board.getTitle() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= board.getWriter() %></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td><%= board.getRegDate() %></td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td><%= board.getReadCount() %></td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>		                
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">
		                <%= board.getContent().replace("\r\n", "<br>") %>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<% Member member = (Member)session.getAttribute("loginuser"); %>
		        	<% if (member.getMemberId().equals(board.getWriter())) { %>
		        	[&nbsp;<a href='edit.action?boardno=<%= board.getBoardNo() %>'>수정</a>&nbsp;]
		        	[&nbsp;<a href='delete.action?boardno=<%= board.getBoardNo() %>'>삭제</a>&nbsp;]
		        	[&nbsp;<a id='delete-btn' href='javascript:'>확인삭제</a>&nbsp;]
		        	<% } %>
		        	[&nbsp;<a href='list.action'>목록보기</a>&nbsp;]
		        </div>
		    </div>
		</div>
		<!-- comment 쓰기 영역 -->		
		<!-- / comment 쓰기 영역 -->		
        <!-- comment 표시 영역 -->        			
		<!-- / comment 표시 영역 -->        
	</div>
	</div>
	<br><br><br><br><br>	
	<script type="text/javascript">
	var deleteBtn = document.querySelector('#delete-btn');
	deleteBtn.addEventListener('click', function(event) {
		event.preventDefault();
		var ok = confirm('삭제할까요?');
		if (ok) {
			location.href = 'delete.action?boardno=<%= board.getBoardNo() %>';
		}
	});
	</script>

</body>
</html>















