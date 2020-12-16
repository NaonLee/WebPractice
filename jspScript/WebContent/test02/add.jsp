<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException,jsp"%>
    
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	for (int i = 0; i <= num; i++)
		sum += i;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculate sum</title>
</head>
<body>
	<h2>Calculate sum</h2>
	<h1>Sum of 1 to <%=num %> is <%=sum %></h1>
</body>
</html>