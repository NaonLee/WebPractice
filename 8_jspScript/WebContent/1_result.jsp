<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print result</title>
</head>
<body>
	<h1>Result</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
	%>
	<h1>Id: <%=id %></h1>
	<h1>password: <%=pwd %></h1>
</body>
</html>