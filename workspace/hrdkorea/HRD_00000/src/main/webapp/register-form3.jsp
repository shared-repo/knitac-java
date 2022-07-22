<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBPKG.ConnectionHelper"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>

	<header style="position:fixed; top:0; text-align:center; width:100%; height:50px; background-color:blue; font-size:25pt; color:white">쇼핑몰 회원관리 ver 1.0</header>
	<nav style="position:fixed; top:50px; width:100%; height:25px; background-color:purple;font-size:13pt; color:white">
		<a href="register-form.jsp">회원등록</a>
		&nbsp;회원목록조회/수정 회원매출조회 홈으로
	</nav>
	<section style="position:fixed; top:75px; width:100%">
	
	<h2 style="text-align: center">홈쇼핑 회원 등록</h2>
	<!-- <form id="register-form" action="register.jsp" method="post"> -->
	<form id="register-form" action="register-form.jsp" method="post">
	<table border="1" align="center">
		<tr>
			<th style="width:200px">회원번호(자동발생)</th>
			<td style="width:450px"><input type="text" readonly id="custno" name="custno"></td>
		</tr>
		<tr>
			<th style="width:200px">회원성명</th>
			<td style="width:450px"><input type="text" id="custname" name="custname"></td>
		</tr>
		<tr>
			<th style="width:200px">전화번호</th>
			<td style="width:450px"><input type="text" id="phone" name="phone"></td>
		</tr>
		<tr>
			<th style="width:200px">주소</th>
			<td style="width:450px"><input type="text" id="address" name="address"></td>
		</tr>
		<tr>
			<th style="width:200px">가입일자</th>
			<td style="width:450px"><input type="text" id="joindate" name="joindate"></td>
		</tr>
		<tr>
			<th style="width:200px">고객등급<br>(A:VIP,B:일반,C:직원)</th>
			<td style="width:450px"><input type="text" id="grade" name="grade"></td>
		</tr>
		<tr>
			<th style="width:200px">도시코드</th>
			<td style="width:450px"><input type="text" id="city" name="city"></td>
		</tr>
		<tr>			
			<td colspan="2" style="text-align:center">
				<input type="submit" id="register-btn" value="등록">
				<input type="button" value="취소" onclick="location.href='index.jsp'">
			</td>
		</tr>
	
	</table>
	</form>
	
	</section>
	<footer style="position:fixed; bottom:0; text-align:center; width:100%; height:50px; background-color:blue;font-size:15pt; color:white">Copyright Info</footer>
	
	<script type="text/javascript">
	
		
	</script>
	

</body>
</html>












