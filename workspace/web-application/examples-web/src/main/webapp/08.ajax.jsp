<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<button id="sync-req">동기(전체화면갱신) 방식 요청</button>
&nbsp;
<button id="async-req">비동기(부분화면갱신) 방식 요청</button>
<hr>
<div id="result"></div>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(function() {
	
	$('#sync-req').on('click', function(event) {
		// alert('sync');
		location.href = "/examples-web/get-time.action";
	});
	
	$('#async-req').on('click', function(event) {
		//alert('async');
		$.ajax({
			"url" : "/examples-web/get-time.action",
			"method" : "get",
			"async" : true,
			"dataType" : "text",
			"success" : function(data, status, xhr) { // 정상 응답일 때 호출되는 함수
				var resultHtml = $("<h3>" + data + "</h3>"); // 지정된 HTML로 확장요소집합 생성
				var div = $('#result');
				// resultHtml.appendTo(div);
				div.append(resultHtml);
			},
			"error" : function(xhr, status, err) { // 오류가 있을 때 호출되는 함수
				alert('비동기 요청 처리 중 오류 발생');
			}
		});
	});
	
});
</script>

</body>
</html>










