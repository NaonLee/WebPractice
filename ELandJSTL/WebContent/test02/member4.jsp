<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");
	session.setAttribute("address", "수원시 팔달구");	//page>request>session>application
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print binding properties-Priority of scope</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%"><b>Id</b></td>
			<td width="7%"><b>Pwd</b></td>
			<td width="5%"><b>Name</b></td>
			<td width="5%"><b>Email</b></td>
			<td width="5%"><b>Address</b></td>
		</tr>
		<tr align="center">
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${email}</td>
			<td>${address}</td>
		</tr>
	</table>
</body>
</html>