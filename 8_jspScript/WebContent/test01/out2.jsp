<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = (String)request.getParameter("name");
	String age = (String)request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit object out 1</title>
</head>
<body>
	<%
		if(name != null || name.length() != 0){
	%>
		<h1><%=name %>, <%=age %></h1>						<!-- print by expression -->
	<%
		} else {
	%>
		<h1>Please enter the name</h1>
	<%
		}
	%>
	
	<%
		if(name != null || name.length() != 0){
	%>
		<h1><% out.println(name + ", " + age); %></h1>			<!-- print by out, implicit object -->
	<%
		} else {
	%>
		<h1>Please enter the name</h1>
	<%
		}
	%>
</body>
</html>