<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageScope</title>
</head>
<body>
	<%
	pageContext.setAttribute("name", "page minst");
	request.setAttribute("name", "request minst");
	session.setAttribute("name", "session minst");
	application.setAttribute("name", "application minst");
	%>
	
	JSP Page 영역 접근 : <%= pageContext.getAttribute("name") %><br>
	EL (Page) : ${pageScope.name} <br>
	EL (Request) : ${requestScope.name} <br>
	EL (Session) : ${sessionScope.name} <br>
	EL (Application) : ${applicationScope.name} <br>
	
	그냥 속성 작성 :${name } <br>
	
	쿠키(대괄호 접근) : ${cookie["JSESSIONID"].value} <br>
	쿠키(dot 접근) : ${cookie.JSESSIONID.value} <br>
	
	<a href = "index.html"> 홈으로 </a>
	
</body>
</html>