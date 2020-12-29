<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("id", "Son");
	request.setAttribute("pwd", "123455");
	request.setAttribute("name", "shownu");
	request.setAttribute("email", "Son@test.com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward1</title>
</head>
<body>
	<jsp:forward page="member1.jsp"></jsp:forward>
</body>
</html>