<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("address", "수원시 영통구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward page</title>
</head>
<body>
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>