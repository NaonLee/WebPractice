<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit object scope test 2</title>
</head>
<body>
	<h1>Name is <%=name %></h1>
	<h1>Address is <%=address %></h1>
</body>
</html>