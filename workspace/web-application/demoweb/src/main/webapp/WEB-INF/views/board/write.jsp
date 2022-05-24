<%@page import="com.demoweb.dto.Member"%>
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
		        	  action="write.action" 
		        	  method="post">
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
		                	<% Member member = (Member)session.getAttribute("loginuser"); %>
							<%-- <input type="text" name="writer" style="width:550px" 
								   value="<%= member.getMemberId() %>" readonly> --%>
							<%= member.getMemberId() %>
							<input type="hidden" 
								   name="writer" value="<%= member.getMemberId() %>">
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
		        	<a id="write" href="javascript:">글쓰기</a>
		        	&nbsp;&nbsp;
		        	<a href="javascript:">목록보기</a>
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>
	
	<script type="text/javascript">
	var writeLink = document.querySelector("#write");
	writeLink.addEventListener("click", function(event) {
		event.preventDefault();
		var writeForm = document.querySelector("#writeform");
		writeForm.submit(); // submit : form을 서버로 전송 (submit button click과 같은 효과)
	});
	</script>

</body>
</html>










