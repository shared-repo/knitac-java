<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	
	<h2 style="text-align:center">RESULT PAGE</h2>
	
	<h2 style="text-align:center">1. <%= pageContext.getAttribute("page-data") %></h2>
	<h2 style="text-align:center">2. <%= request.getAttribute("req-data") %></h2>
	
</body>
</html>





