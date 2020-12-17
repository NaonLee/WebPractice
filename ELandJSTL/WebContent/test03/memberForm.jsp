<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:out practice-form</title>
</head>
<body>
	<form method="post" action="member9.jsp">
		<table align="center">
			<tr>
				 <td><p align="right">Id</p></td>
				 <td width='400'><input type="text" name="id"></td>
			</tr>
			<tr>
				 <td><p align="right">Password</p></td>
				 <td width='400'><input type="password" name="pwd"></td>
			</tr>
			<tr>
				 <td><p align="right">Name</p></td>
				 <td width='400'><input type="test" name="name"></td>
			</tr>
			<tr>
				 <td><p align="right">Email</p></td>
				 <td width='400'><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td><input type="submit" value="register">
				<input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>