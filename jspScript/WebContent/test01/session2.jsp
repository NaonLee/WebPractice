<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String address = (String)session.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit object 3</title>
</head>
<body>
	Name is <%=name %>. <br>
	Address is <%=address %>. <br>
</body>
</html>