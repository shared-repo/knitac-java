<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>사용자등록</title>
	<link rel="Stylesheet" href="/demoweb/resources/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/resources/styles/input.css" />
	<style type="text/css">
	.error {
		color: red;
		font-weight: bold;
	}
	</style>
</head>
<body>

	<div id="pageContainer">

		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle"><spring:message code="register.title" /></div>

		        <form:form id="registerform" 
		        	  	   action="/demoweb/account/register" method="post"
		        	  	   modelAttribute="member"><%-- controller에서 전달하는 객체 --%>
		        <table>
		            <tr>
		                <th><spring:message code="register.id" /></th>
		                <td>
		                    <%-- <form:input type="text" id="memberId" path="memberId" style="width:280px" /> --%>
		                    <input type="text" id="memberId" name="memberid" style="width:280px" />
		                    <br>
		                    <form:errors path="memberId" cssClass="error" /><!-- BindingResult에 등록된 오류 메시지 표시 -->
		                </td>
		            </tr>
		            <tr>
		                <th><spring:message code="register.passwd" /></th>
		                <td>
		                	<form:input type="password" id="passwd" path="passwd" style="width:280px" />
		                	<br>
		                	<form:errors path="passwd" cssClass="error" />
		                </td>
		            </tr>
		            <tr>
		                <th><spring:message code="register.confirm" /></th>
		                <td>
		                    <input type="password" id="confirm" name="confirm" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th><spring:message code="register.email" /></th>
		                <td>
		                	<form:input type="text" id="email" path="email" style="width:280px" />
		                	<br>
		                	<form:errors path="email" cssClass="error" />
		                </td>
		            </tr>
		                       		            
		        </table>
		        <div class="buttons">
		        	<button id="register" style="height:25px">
		        		<spring:message code="register.register" />
		        	</button>
		        	<button id="cancel" style="height:25px">
		        		<spring:message code="register.cancel" />
		        	</button>

		        </div>
		        </form:form>
		    </div>
		</div>   	
	
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#register").on('click', function(event) {
			event.preventDefault();
			
			// 유효성 검사
			/*
			if (!$('#memberId').val()) {
				alert('아이디를 입력하세요');
				return;
			} 
			*/
			
			$('#registerform').submit();
		});
		$("#cancel").on('click', function(event) {
			event.preventDefault();
			location.href = '/demoweb/home';
		});
	});
	</script>

</body>
</html>














