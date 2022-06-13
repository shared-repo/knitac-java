<%@page import="com.demoweb.dto.Board"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>글수정</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />
	<style type="text/css">
	a { text-decoration: none }
	</style>	
		
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 수정</div>
		        <form id="editform" action="edit.action" method="post">
		        <% Board board = (Board)request.getAttribute("board"); %>
		        <table>
		        	<tr>
		                <th>글번호</th>
		                <td>
		                	<input type="hidden" 
		                		   name="boardno" value="<%= board.getBoardNo() %>">
		                	<%= board.getBoardNo() %>
		                </td>
		            </tr>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" style="width:560px"
		                    	   value="<%= board.getTitle() %>">
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= board.getWriter() %></td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>		                    
		                    <textarea name="content" style="resize:none" cols="76" 
		                    	rows="15"><%= board.getContent() %></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">        	
		        	[&nbsp;<a id="edit-btn" href="javascript:">글수정</a>&nbsp;]
		        	&nbsp;&nbsp;
		        	[&nbsp;<a href='detail.action?boardno=<%= board.getBoardNo() %>'>취소1</a>&nbsp;]
		        	[&nbsp;<a href='javascript:history.back()'>취소2</a>&nbsp;]
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>
	
	<script src="/demoweb/js/jquery-3.6.0.js"></script>
	
	<script type="text/javascript">
	/* 
	var editBtn = document.querySelector("#edit-btn");
	editBtn.addEventListener('click', function(event) {
		event.preventDefault();
		var editForm = document.querySelector("#editform");
		editForm.submit(); // 전송 명령
	});
	*/
	$('#edit-btn').on('click', function(event) {
		event.preventDefault();
		$('#editform').submit();
	});
	</script>

</body>
</html>








