<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h3>C:out</h3>
	<c:out value="Hello JSTL1"></c:out>
	<br>
	<c:out value="Hello JSTL2"/>
	<br>
	
	<hr>
	
	<h3>C:Set</h3>
	
	
	<c:set var="name" value="minst"/> ${name} <br>
	<c:set var="name2">minst01</c:set> ${name2} <br>
	
	<c:set var="person" value="<%=new com.ssafy.dto.Person() %>"/>
	<c:set target ="${person}" property="name" value = "minst02"/>
	
	${person }
	
	
	<br>
	<a href="index.html"> 홈으로 </a>
</body>
</html>