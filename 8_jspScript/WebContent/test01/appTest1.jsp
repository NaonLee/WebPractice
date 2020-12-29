<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "Leedo");
	application.setAttribute("address", "수원시 영통구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit object scope test 1</title>
</head>
<body>
	<h1>Set attribute name and address</h1>
	<a href=appTest2.jsp>Move to the second web page</a>
</body>
</html>