<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>It's a spring test</title>
</head>
<body>
	<table border="1" width="100%" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td><b>ID</b></td>
			<td><b>Password</b></td>
			<td><b>Name</b></td>
			<td><b>Email</b></td>
		</tr>
		<tr align="center">
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${email}</td>
		</tr>
	</table>
</body>
</html>