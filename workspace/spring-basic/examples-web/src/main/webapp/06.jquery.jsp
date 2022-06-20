<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Example</title>
</head>
<body>

<div id="message"></div>

<!-- <script src="/examples-web/js/jquery-3.6.0.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
// jQuery(document).ready(function() {
// $(document).ready(function() {
$(function() {	
	alert('jQuery 라이브러리가 준비되었습니다.');	
	var person = {
		"name": "John Doe",
		"email": "johndoe@example.com",
		"phone": { "mobile" : "010-6932-4521",
				   "office" : "02-3214-7789" }
	};
	//            innerHTML
	$('#message').html("<h2>[" + person.name + "][" 
							   + person.email + "]["
							   + person.phone.mobile + "]</h2>");
	
	
		
});

</script>

</body>
</html>








