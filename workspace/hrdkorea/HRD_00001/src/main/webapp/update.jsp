<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBPKG.ConnectionHelper"%>

<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

Connection conn = ConnectionHelper.getConnection();

String sql = "UPDATE member_tbl_02 " +
			 "SET custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? " +
			 "WHERE custno = ?";
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
pstmt.setInt(7, Integer.parseInt(request.getParameter("custno")));

pstmt.executeUpdate();
%>
<script type="text/javascript">
alert("회원수정 완료");
location.href="member-list.jsp";
</script>