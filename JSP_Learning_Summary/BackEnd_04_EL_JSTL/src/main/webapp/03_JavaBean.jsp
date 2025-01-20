<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.Person"%>
<%
Person p = new Person();
p.setName("김민수");
p.setAge(27);
p.setHobbies(new String[] { "공부", "운동" });
p.setGender("남");
pageContext.setAttribute("p", p);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean</title>
</head>
<body>
	<h2>JavaBeans</h2>
	<div>전체 정보 : ${p}</div>
	<div>이름 : ${p.name }</div>
	<div>나이 : ${p["age"] }</div>
	<div>성별 : ${p["gender"] }</div>
	<div>취미 : ${p["hobbies"][0]}</div>

	<a href="index.html"> 홈으로 </a>
</body>
</html>