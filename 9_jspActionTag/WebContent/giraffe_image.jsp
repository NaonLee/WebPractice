<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giraffe image</title>
</head>
<body>
	<br><br>
	<h1>Name is <%=name %>.</h1><br><br>
	<img src="./image/<%=imgName %>"/> 
</body>
</html>