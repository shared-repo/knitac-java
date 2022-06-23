<%@ page import="com.demoweb.dto.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/demoweb/resources/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/resources/styles/input2.css" />
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
		        <div class="inputsubtitle">게시글 쓰기</div>
		        <form id="writeform" 
		        	  action="write" 
		        	  method="post"
		        	  enctype="multipart/form-data">
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" style="width:550px" />
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>
							<%-- <input type="text" name="writer" style="width:550px" 
								   value="${ loginuser.memberId }" readonly> --%>
							${ loginuser.memberId }
							<input type="hidden" 
								   name="writer" value="${ loginuser.memberId }">
		                </td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>		                    
		                    <input type="file" name="attach">
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>		                    
		                    <textarea style="resize: none"
		                    		  name="content" cols="76" rows="15"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">		        	
		        	[<a id="write" href="javascript:">글쓰기</a>]
		        	&nbsp;&nbsp;
		        	[<a href="list">목록보기(상대경로)</a>]
		        	[<a href="/demoweb/board/list">목록보기(절대경로)</a>]
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>
	
	<!-- <script src="/demoweb/js/jquery-3.6.0.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script type="text/javascript">
	/* 
	var writeLink = document.querySelector("#write");
	writeLink.addEventListener("click", function(event) {
		event.preventDefault();
		var writeForm = document.querySelector("#writeform");
		writeForm.submit(); // submit : form을 서버로 전송 (submit button click과 같은 효과)
	}); 
	*/
	$(function() {
		
		$('#write').on('click', function(event) { // on : jquery의 이벤트 연결 함수 (addEventListener)
			event.preventDefault();
			$('#writeform').submit();
		});
		
	});
	</script>

</body>
</html>










