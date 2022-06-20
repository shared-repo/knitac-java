<%@page import="com.demoweb.dto.BoardAttach"%>
<%@page import="com.demoweb.dto.Member"%>
<%@page import="com.demoweb.dto.Board"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8" %>
		 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>${ board.title }</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${ requestScope.board.writer }</td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td>${ board.regDate }</td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td>${ board.readCount }</td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                <c:forEach var="file" items="${ board.files }">
		                <a href="download.action?attachno=${ file.attachNo }">
		                ${ file.userFileName }
		                </a>
		                <br>
		                </c:forEach>
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">
<% String enter2 = "\r\n"; %>
<c:set var="enter" value="
" />
		                ${ fn:replace(board.content, enter, '<br>') }
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<c:if test="${ loginuser.memberId eq board.writer }">
		        	[&nbsp;<a href='edit.action?boardno=${ board.boardNo }'>수정</a>&nbsp;]
		        	[&nbsp;<a href='delete.action?boardno=${ board.boardNo }'>삭제</a>&nbsp;]
		        	[&nbsp;<a id='delete-btn' href='javascript:'>확인삭제</a>&nbsp;]
		        	</c:if>
		        	[&nbsp;<a href='list.action?pageNo=${ pageNo }'>목록보기</a>&nbsp;]
		        </div>
		    </div>
		</div>
		
		<!-- comment 쓰기 영역 -->	
		<div>
		</div>	
		<!-- / comment 쓰기 영역 -->	
			
        <!-- comment 표시 영역 -->        			
		<!-- / comment 표시 영역 -->        
	</div>
	</div>
	<br><br><br><br><br>
	
	<script src="/demoweb/js/jquery-3.6.0.js"></script>	
	<script type="text/javascript">
	/*
	var deleteBtn = document.querySelector('#delete-btn');
	deleteBtn.addEventListener('click', function(event) {
		event.preventDefault();
		var ok = confirm('삭제할까요?');
		if (ok) {
			location.href = 'delete.action?boardno=${ board.boardNo }';
		}
	});
	*/
	// $('#delete-btn').on('click', function(event)) {
	$('#delete-btn').click(function(event) {
		event.preventDefault();
		var ok = confirm('삭제할까요?');
		if (ok) {
			location.href = 'delete.action?boardno=${ board.boardNo }';
		}
		
	});
	</script>

</body>
</html>















