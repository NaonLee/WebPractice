<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member registration page</title>
</head>
<body>
	<form method="post" action="member6.jsp">
		<h1 style="text-align:center">Registration page</h1>
		
		<table align="center">
			<tr>
				<td width="200">
					<p align="right">Id
				</td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">Password
				</td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">Name
				</td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200">
					<p align="right">Email
				</td>
				<td width="400"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td>
					<input type="submit" value="Register">
					<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>