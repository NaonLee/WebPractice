<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print result3</title>
</head>
<body>
	<h1>Result</h1>
	
	<% if (id == null || id.length() == 0){ %>
	Please input your id<br>
	<a href='/jspScript/1_login.jsp'>login</a>
	<% }else{ 
			if(id.equals("admin")){	
	%>
			<h1>login as an administrator.</h1>
			<form>
				<input type="button" value="Delete user">
				<input type="button" value="Add user">
			</form>
	<% 
			} else{ 
	%>
		<h1>WELCOME!</h1>
		<h1>Id: <%=id %></h1>
		<h1>password: <%=pwd %></h1>
	<%
			} 
		}
	%>
</body>
</html>