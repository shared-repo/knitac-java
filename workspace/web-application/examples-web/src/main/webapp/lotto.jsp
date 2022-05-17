<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lotto</title>
</head>
<body>
<%!
int[] selectBasicNumbers() {
	int[] numbers = new int[6];
	for (int i = 0; i < numbers.length; i++) {				
		numbers[i] = (int)(Math.random() * 45) + 1;
		// 중복검사를 위한 반복 ( 0부터 현재 뽑힌 위치 i 이전까지 비교 )
		for (int j = 0; j < i; j++) {
			if (numbers[i] == numbers[j]) { // 현재뽑힌번호 == 이전뽑힌번호 / 중복 발생한 경우
			
				// i--; // 현재 위치의 번호 다시 뽑기
				i = -1; // 처음부터 다시 뽑기
				break;
			}
		}
	}
	return numbers;
}
%>

<%
ArrayList<int[]> numbersList = new ArrayList<int[]>();
for (int i = 0; i < 10; i++) {
	int[] numbers = selectBasicNumbers();
	numbersList.add(numbers);
}
%>

<table width='600' border='1' align='center'>
	<caption style='font-size:20pt;text-align:center'>당첨 예상 번호</caption>
	<% for (int[] numbers : numbersList) { %>
	<tr style='height:50px'>
		<% for (int i = 0; i < numbers.length; i++) { %>
		<th><%= numbers[i] %></th>
		<% } %>
	</tr>
	<% } %>
</table>

</body>
</html>













