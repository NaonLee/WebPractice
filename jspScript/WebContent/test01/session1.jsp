<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	session.setAttribute("address", "수원시 영통구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit object 1</title>
</head>
<body>
	Name is <%=name %>.<br>
	<a href='session2.jsp'>Move to the second page</a>
</body>
</html>