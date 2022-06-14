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
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>글쓰기</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
		  rel="stylesheet">
	
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
		<br><br>
		<!-- comment 쓰기 영역 -->	
		<div>
			<button id="add-comment-btn" type="button" 
					class="btn btn-outline-primary btn-sm">댓글쓰기</button>
		</div>	
		<!-- / comment 쓰기 영역 -->	
			
        <!-- comment 표시 영역 -->
        
		<!-- / comment 표시 영역 -->        
	</div>
	</div>
	<br><br><br><br><br>
	
	<!-- Modal -->
	<div id="comment-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="comment-modal-label" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="comment-modal-label">댓글 쓰기</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
            			<span aria-hidden="true">×</span>
          			</button>					
				</div>
				<div class="modal-body">
				<form id="comment-form">
					<div class="form-group">
						<label>댓글</label>
						<input class="form-control" name='comment' id='modal-comment' value=''>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name='writer' id='modal-commenter' value=''>
					</div>
					<input type="hidden" name='bno' value='${ board.boardNo }'>
					<input type="hidden" name='rno'>
					<input type="hidden" name='action'><!-- 댓글 or 댓글의 댓글 -->
				</form>
				</div>
				<div class="modal-footer">
					<button id='modalModBtn' type="button" class="btn btn-success">Modify</button>
					<button id='modalRemoveBtn' type="button" class="btn btn-success">Remove</button>
					<button id='modalRegisterBtn' type="button" class="btn btn-success">Register</button>
					<button id='modalCloseBtn' type="button" class="btn btn-success">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	<script src="/demoweb/js/jquery-3.6.0.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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
	
	///////////////////////////////////////////////////
	
	$('#add-comment-btn').on('click', function(event) {
		$('#comment-modal').modal('show'); // show modal
	});
	
	$('#modalCloseBtn').on('click', function(event) {
		$('#comment-modal').modal('hide'); // hide modal
	});
	</script>

</body>
</html>















