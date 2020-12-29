<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" import="sec01.ex02.MemberBean"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print binding properties-forward3</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>Email</b></td>
		</tr>
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		<tr align="center">
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
	</table>
</body>
</html>