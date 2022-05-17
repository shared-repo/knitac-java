<%@ page import="java.util.Date" %>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Structure</title>
</head>
<body>

	<%-- JSP 주석 : 서버에서 컨테이너가 무시하는 영역 ( 응답에 포함되지 않습니다 ) --%>
	<!-- HTML 주석 : 서버에서 처리되는 영역 ( 응답에 포함됩니다 ), 브라우저에서 무시되는 영역 -->
	
	<h3>1. <% out.write(new Date().toString()); %></h3>
	<h3>2. <%= new Date().toString() %></h3> <%-- <%=는 <% out.write(...);와 같은 역할 --%>

</body>
</html>
