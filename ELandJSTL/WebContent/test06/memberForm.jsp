<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member join page</title>
</head>
<body>
	<form method="post" action="member_action.jsp">
		<h1 style="text-align: center">Member join page</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">Id</td>
				<td width="200"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Password</td>
				<td width="200"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Name</td>
				<td width="200"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Email</td>
				<td width="200"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400"><input type="submit" value="Register">
				<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>