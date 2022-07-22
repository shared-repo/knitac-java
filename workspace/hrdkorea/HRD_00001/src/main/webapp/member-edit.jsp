<%@page import="DTO.Member"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBPKG.ConnectionHelper"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
    	 
<%
	Connection conn = ConnectionHelper.getConnection();
	
	String sql = "SELECT custno, custname, phone, address, joindate, grade, city " + 
				 "FROM member_tbl_02 " + 
				 "WHERE custno = ?";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, Integer.parseInt(request.getParameter("custno")));
	ResultSet rs = pstmt.executeQuery();
	Member member = null;
	if (rs.next()) {
		member = new Member();
		member.setCustNo(rs.getInt(1));
		member.setCustName(rs.getString(2));
		member.setPhone(rs.getString(3));
		member.setAddress(rs.getString(4));
		member.setJoinDate(rs.getDate(5));
		member.setGrade(rs.getString(6));
		member.setCity(rs.getString(7));
	}
	
	rs.close();
	pstmt.close();
	conn.close();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>

	<jsp:include page="header.jsp" />
		
	<section style="position:fixed; top:75px; width:100%">
	
	<h2 style="text-align: center">홈쇼핑 회원 등록</h2>
	<form id="update-form" action="update.jsp" method="post">
	<table border="1" align="center">
		<tr>
			<th style="width:200px">회원번호</th>
			<td style="width:450px"><input type="text" readonly id="custno" name="custno" value="<%= member.getCustNo() %>"></td>
		</tr>
		<tr>
			<th style="width:200px">회원성명</th>
			<td style="width:450px"><input type="text" id="custname" name="custname" value="<%= member.getCustName() %>"></td>
		</tr>
		<tr>
			<th style="width:200px">전화번호</th>
			<td style="width:450px"><input type="text" id="phone" name="phone" value="<%= member.getPhone() %>"></td>
		</tr>
		<tr>
			<th style="width:200px">주소</th>
			<td style="width:450px"><input type="text" id="address" name="address" value="<%= member.getAddress() %>"></td>
		</tr>
		<tr>
			<th style="width:200px">가입일자</th>
			<td style="width:450px"><input type="text" id="joindate" name="joindate" value="<%= member.getJoinDate() %>"></td>
		</tr>
		<tr>
			<th style="width:200px">고객등급<br>(A:VIP,B:일반,C:직원)</th>
			<td style="width:450px"><input type="text" id="grade" name="grade" value="<%= member.getGrade() %>"></td>
		</tr>
		<tr>
			<th style="width:200px">도시코드</th>
			<td style="width:450px"><input type="text" id="city" name="city" value="<%= member.getCity() %>"></td>
		</tr>
		<tr>			
			<td colspan="2" style="text-align:center">
				<input type="submit" id="update-btn" value="수정">
				<input type="button" value="조회" onclick="location.href='member-list.jsp'">
			</td>
		</tr>
	
	</table>
	</form>
	
	</section>
	<jsp:include page="footer.jsp" />
		
	<script type="text/javascript">
	
	window.addEventListener('load', function(event) {
	
		var updateBtn = document.querySelector('#update-btn');
		updateBtn.addEventListener("click", function(event) {
			event.preventDefault();
			
			// 유효성 검사
			var enNames = ['custname', 'phone', 'address', 'joindate', 'grade', 'city'];
			var koNames = ['회원성명', '전화번호', '주소', '가입일자', '고객등급', '도시코드'];
			for (var i = 0; i < enNames.length; i++) {
				var input = document.querySelector('#' + enNames[i]);
				if (input.value.length == 0) {
					alert(koNames[i] + '을(를) 입력하세요');
					input.focus();
					return;
				}
				else if (enNames[i] === 'joindate') {
					var datePattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
					if (!datePattern.test(input.value)) {
						alert(koNames[i] + ' 형식 오류');
						input.focus();
						return;
					}
				}
				else if (enNames[i] ==='grade' && 
						input.value !== 'A' && input.value !== 'B' && input.value !== 'C') {
					alert(koNames[i] + " 형식 오류");
					input.focus();
					return;	
				}
				else if (enNames[i] ==='city') {
					var cityPattern = /^[0-9]{2}$/;
					if (!cityPattern.test(input.value)) {
						alert(koNames[i] + " 형식 오류");
						input.focus();
						return;
					}
				}
			}			
			
			var form = document.querySelector("#update-form");
			form.submit();
			
		});
		
	});
		
	</script>
	

</body>
</html>












