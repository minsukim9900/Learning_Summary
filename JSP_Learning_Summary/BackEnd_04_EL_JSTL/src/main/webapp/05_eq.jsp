<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EQ</title>
</head>
<body>
<!--  URL 쿼리스트링을 작성해서 보았어 -->
	<%= request.getParameter("id") %><br>
	${param.id} <br>
	
	== : <%= request.getParameter("id") == "minsu" %> <br>
	equals() <%= request.getParameter("id").equals("minsu") %><br>
	
	
	== (EL) : ${param.id == "minsu"}<br>
	eq (EL) : ${param.id eq "minsu"}<br>
	
	<a href = "index.html"> 홈으로 </a>
	
	
	
</body>
</html>