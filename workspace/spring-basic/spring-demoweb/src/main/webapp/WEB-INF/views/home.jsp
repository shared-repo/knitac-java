<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Home</title>
	<link rel='Stylesheet' href='/demoweb/resources/styles/default.css' />
</head>
<body>

	<div id='pageContainer'>
		
		<%-- <% pageContext.include("/WEB-INF/views/modules/header.jsp"); %> --%>
		
		<%-- jsp:include : 함수 호출, jsp:param : 전달인자 --%>
		<jsp:include page="/WEB-INF/views/modules/header.jsp">
			<jsp:param name="bg_color" value="purple" />
		</jsp:include>
		
		<div id='content'>
			<br /><br /><br />
			<h2 style='text-align:center'>Welcome to Demo WebSite !!!</h2>
		</div>
	</div>

</body>
</html>


