<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%!
 	String name="이도";
 	public String getName(){return name;}
 %>
 <% String age=request.getParameter("age"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression practice</title>
</head>
<body>
	<h1>Hello <%=name %>!</h1>
	<h1>Age is <%=age %></h1>
	<h1>Age+10 = <%=Integer.parseInt(age)+10 %></h1>
</body>
</html>