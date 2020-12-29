<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	String name = "Duke";
    	public String getName(){ return name;}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration tag practice</title>
</head>
<body>
	<h1>Hello <%=name %>!</h1>
</body>
</html>