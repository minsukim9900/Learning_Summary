<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = "김민수";
	%>
	
	<h2>Hello JSP</h2>
	<h4>
		안녕하세요.<%= name%>입니다.
	</h4>
	
	<a href="index.html">홈으로</a>

</body>
</html>