<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Op</title>
</head>
<body>
	\${5+2} : ${5+2}
	<br> \${5/2} : ${5/2}
	<!-- <br> \${5 div 2} : ${5 div 2} -->
	<!--  실수 연산을 해준다. -->
	<br> \${5 gt 2} : ${5 gt 2}
	<br> \${5 < 2} : ${5 < 2}
	<br> \${5 gt 2 ? 1 : 0} : ${5 gt 2 ? 1 : 0};
	<br> \${5 le 5 ? 1 : 0} : ${5 le 5 ? 1 : 0};
	<br> \${5 mod 5} : ${5 mod 5};
	<br> \${5 eq 5} : ${5 eq 5};

	<br> <a href="index.html"> 홈으로 </a>

</body>
</html>