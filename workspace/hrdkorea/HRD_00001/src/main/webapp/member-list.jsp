<%@page import="DTO.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DBPKG.ConnectionHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<%!
String getGradeName(String grade) {
	switch (grade) {
		case "A" : return "VIP";
		case "B" : return "일반";
		case "C" : return "직원";
		default : return "";
	}
}
%>
<%
	Connection conn = ConnectionHelper.getConnection();
	
	String sql = "SELECT custno, custname, phone, address, joindate, grade, city FROM member_tbl_02";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
	ArrayList<Member> members = new ArrayList<Member>();
	while (rs.next()) {
		Member member = new Member();
		member.setCustNo(rs.getInt(1));
		member.setCustName(rs.getString(2));
		member.setPhone(rs.getString(3));
		member.setAddress(rs.getString(4));
		member.setJoinDate(rs.getDate(5));
		member.setGrade(rs.getString(6));
		member.setCity(rs.getString(7));
		members.add(member);
	}
	
	rs.close();
	pstmt.close();
	conn.close();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<section style="position:fixed; top:75px; width:100%">
	<br><br>
	<h2 style='text-align:center'>회원목록조회/수정</h2>
	<table border="1" align="center" width="1000">
		<tr style="backgroun-color:orange;height:35px">
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
		<% for (Member member : members) { %>
		<tr style="height:35px">
			<td style="text-align:center"><a href="member-edit.jsp?custno=<%= member.getCustNo() %>"><%= member.getCustNo() %></a></td>
			<td style="text-align:center"><%= member.getCustName() %></td>
			<td style="text-align:center"><%= member.getPhone() %></td>
			<td style="text-align:center"><%= member.getAddress() %></td>
			<td style="text-align:center"><%= member.getJoinDate() %></td>
			<td style="text-align:center"><%= getGradeName(member.getGrade()) %></td>
			<td style="text-align:center"><%= member.getCity() %></td>
		</tr>
		<% } %>
		
	</table>
	
	</section>
	<jsp:include page="footer.jsp" />

</body>
</html>