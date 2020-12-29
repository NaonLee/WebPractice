<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using requestScope page</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>Email</b></td>
			<td width="20%"><b>Address</b></td>
		</tr>

		<tr align="center">
			<td>${param.id}</td>
			<td>${param.pwd}</td>
			<td>${param.name}</td>
			<td>${param.email}</td>
			<td>${requestScope.address}</td>
		</tr>
	</table>
</body>
</html>