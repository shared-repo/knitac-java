<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>

	<meta charset="utf-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/styles/default.css" />
	<link rel="Stylesheet" href="/styles/input2.css" />

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
		                <td></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td>
		                	
		                </td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>		                
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">
		            </tr>
		        </table>
		        <div class="buttons">
		        	
		        	[&nbsp;<a id='update-btn' href='javascript:'>수정</a>&nbsp;]
		        	[&nbsp;<a id='delete-btn' href='javascript:'>삭제</a>&nbsp;]
		        	[&nbsp;<a href='j'>목록보기</a>&nbsp;]
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

</body>
</html>