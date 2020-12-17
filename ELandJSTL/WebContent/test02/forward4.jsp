<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sec01.ex02.MemberBean, java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("id", "Son");
	request.setAttribute("pwd", "123455555");
	session.setAttribute("name", "Shownu1");
	application.setAttribute("email", "sib1@tess.com");
	request.setAttribute("address", "수원시 영통구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward4</title>
</head>
<body>
	<jsp:forward page="member4.jsp"></jsp:forward>
</body>
</html>