<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬을 골라보자</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="10_checkBoxResult.jsp">
		<input type = "checkbox" name="dish" value="피자">피자
		<input type = "checkbox" name="dish" value="치킨">치킨
		<input type = "checkbox" name="dish" value="모수">모수 <br>
		<input type = "checkbox" name="dish" value="바위굴">바위굴
		<input type = "checkbox" name="dish" value="명란젓">명란젓
		<input type = "checkbox" name="dish" value="초밥">초밥
		<button>구매</button>
	</form>
</body>
</html>