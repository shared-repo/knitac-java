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
	
	String sql = "SELECT m.custno, m.custname, m.grade, NVL(s.price, 0) sales " + 
				 "FROM member_tbl_02 m " +
				 "LEFT OUTER JOIN money_tbl_02 s " +
				 "ON m.custno = s.custno " +
				 "ORDER BY m.custno";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
	ArrayList<Member> members = new ArrayList<Member>();
	while (rs.next()) {
		Member member = new Member();
		member.setCustNo(rs.getInt(1));
		member.setCustName(rs.getString(2));
		member.setGrade(rs.getString(3));
		member.setSales(rs.getInt(4));
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
			<th>고객등급</th>
			<th>매출</th>
		</tr>
		<% for (Member member : members) { %>
		<tr style="height:35px">
			<td style="text-align:center"><%= member.getCustNo() %></td>
			<td style="text-align:center"><%= member.getCustName() %></td>
			<td style="text-align:center"><%= getGradeName(member.getGrade()) %></td>
			<td style="text-align:center"><%= member.getSales() %></td>
		</tr>
		<% } %>
		
	</table>
	
	</section>
	<jsp:include page="footer.jsp" />

</body>
</html>