<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBPKG.ConnectionHelper"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
    	 
<%
if (request.getMethod().toLowerCase().equals("post")) {
	request.setCharacterEncoding("utf-8");
	Connection conn = ConnectionHelper.getConnection();
	
	String sql = "INSERT INTO member_tbl_02 " +
				 "(custno, custname, phone, address, joindate, grade, city) " +
				 "VALUES (member_tbl_02_sequence.nextval, ?, ?, ?, ?, ?, ?) ";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, request.getParameter("custname"));
	pstmt.setString(2, request.getParameter("phone"));
	pstmt.setString(3, request.getParameter("address"));
	String sJoinDate = request.getParameter("joindate");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date joinDate = 
		new Date(sdf.parse(sJoinDate).getTime()); // parse : String -> java.util.Date
												  // java.util.Date.getTime() : 1/1000초)
												  // new java.sql.Date(1/1000초)
	pstmt.setDate(4, joinDate);
	pstmt.setString(5, request.getParameter("grade"));
	pstmt.setString(6, request.getParameter("city"));
	
	pstmt.executeUpdate();
}
%>

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
	
	window.addEventListener('load', function(event) {
		
		<% if (request.getMethod().toLowerCase().equals("post")) { %>
			alert("회원등록 완료");
			location.href="index.jsp";
		<% } %>
		
		var registerBtn = document.querySelector('#register-btn');
		registerBtn.addEventListener("click", function(event) {
			event.preventDefault();
			
			// 유효성 검사
			var custName = document.querySelector('#custname');
			if (custName.value.length == 0) {
				alert('이름을 입력하세요');
				custName.focus();
				return;
			}
			
			var phone = document.querySelector('#phone');
			if (phone.value.length == 0) {
				alert('전화번호를 입력하세요');
				phone.focus();
				return;
			}
			if (phone.value.length > 13) {
				alert('전화번호 형식 오류');
				phone.focus();
				return;
			}
			for (var i = 0; i < phone.value.length; i++) {
				var c = phone.value[i];
				if (c != '-' && isNaN(c)) { // isNaN : 숫자가 아니면 true
					alert('전화번호 형식 오류');
					phone.focus();
					return;
				}
			}
			
			// 유효성 검사 계속...
			
			var form = document.querySelector("#register-form");
			form.submit();
			
		});
		
	});
		
	</script>
	

</body>
</html>












