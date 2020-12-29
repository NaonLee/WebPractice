<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		if(msg != null){
	%>
		<h1> <%=msg %></h1>
	<%
		}
	%>
		<form action="result2.jsp" method="post">
			Id: <input type="text" name="id">
			Password: <input type="password" name="password">
			<input type="submit" value="login">
			<input type="reset" value="reset">
		</form>
</body>
</html>