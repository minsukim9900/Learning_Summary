<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬 결과</title>
</head>
<body>
	<c:forEach items="${paramValues.dish }" var="dish" varStatus="status">
	${dish} <c:if test="${not status.last}">, </c:if>
	</c:forEach>
	
	
	<br>
	<a href="index.html"> 홈으로 </a>
</body>
</html>