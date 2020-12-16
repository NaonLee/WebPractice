<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="ture"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
	==================toString()====================<br>
	<h1><%= exception.toString() %></h1>
	==================getMessage()====================<br>
	<h1><%=exception.getMessage() %></h1>
	================printStackTrace()=================<br>
	<h1><%=exception.printStackTrace(); %></h1>
	<h3>Only integer is acceptable. Please retry.
	<a href='add.html'>Retry</a></h3>
</body>
</html>