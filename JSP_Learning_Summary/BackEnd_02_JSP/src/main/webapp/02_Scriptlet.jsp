<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
	<h2>스크립트릿 연습</h2>
	
	<%
		int A = 10;
		int B = 20;
		
		int sum = A + B;
	
	%>
	
	<h2>결과는 <%= sum %> 입니다.</h2>
	
	<br>
	<a href = "index.html">홈으로</a>
</body>
</html>