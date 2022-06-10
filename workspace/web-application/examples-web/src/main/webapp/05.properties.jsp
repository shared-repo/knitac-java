<%@page import="com.exampleweb.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Property Test</title>
</head>
<body>
	<% Member member = new Member(); %>
	<jsp:useBean id="member2" class="com.exampleweb.dto.Member" />
	
	
	<% member.setMemberId("johndoe"); %>
	<jsp:setProperty name="member2" property="memberId" value="janedoe" />
	
	<h3><%= member.getMemberId() %></h3>
	<h3><jsp:getProperty name="member2" property="memberId" /></h3>
	

</body>
</html>