<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	String name="이도";
	public String getName(){return name;}
%>
<% String age = request.getParameter("age"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet practice</title>
</head>
<body>
	<h1>hello <%=name %>!</h1>
	<h1>age is <%=age %></h1>
</body>
</html>