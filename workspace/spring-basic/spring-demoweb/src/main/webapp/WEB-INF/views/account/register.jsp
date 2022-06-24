<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>사용자등록</title>
	<link rel="Stylesheet" href="/demoweb/resources/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/resources/styles/input.css" />

</head>
<body>

	<div id="pageContainer">

		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle"><spring:message code="register.title" /></div>

		        <form id="registerform" 
		        	  action="/demoweb/account/register" method="post">
		        <table>
		            <tr>
		                <th><spring:message code="register.id" /></th>
		                <td>
		                    <input type="text" id="memberId" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th><spring:message code="register.passwd" /></th>
		                <td>
		                	<input type="password" id="passwd" name="passwd" style="width:280px" />
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
		                	<input type="text" id="email" name="email" style="width:280px" />
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
		        </form>
		    </div>
		</div>   	
	
	</div>

</body>
</html>














