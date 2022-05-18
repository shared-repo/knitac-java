<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<%

pageContext.setAttribute("page-data", "This is Page Scope Data (from forward)");
// request 객체에 데이터 저장
request.setAttribute("req-data", "This is Request Scope Data (from forward)");

//forward 방식으로 다른 처리기로 이동 : JSP에서 사용할 수 있는 구문	
//pageContext.forward("02.result.jsp");

//forward 방식으로 다른 처리기로 이동 : JSP와 Servlet에서 사용할 수 있는 구문
RequestDispatcher dispatcher = request.getRequestDispatcher("02.result.jsp");
dispatcher.forward(request, response);	// forward 방식으로 02.result.jsp로 이동

%>