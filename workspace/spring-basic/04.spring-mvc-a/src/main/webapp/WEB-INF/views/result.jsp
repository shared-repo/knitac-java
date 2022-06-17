<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
    	 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>result page</title>
</head>
<body>

<h1>This is result page</h1>
<h2>0.
	[${ msg }][${ cnt }][${ requestScope.test }]

</h2>
<h2>1.
	[${ myperson.name }]
	[${ myperson.phone }]
	[${ myperson.email }]
	[${ requestScope.myperson.age }]
</h2>
<h2>2.
	[${ person.name }]
	[${ person.phone }]
	[${ person.email }]
	[${ requestScope.person.age }]
</h2>
<h2>3.
	[${ myperson2.name }]
	[${ myperson2.phone }]
	[${ myperson2.email }]
	[${ requestScope.myperson2.age }]
</h2>

</body>
</html>