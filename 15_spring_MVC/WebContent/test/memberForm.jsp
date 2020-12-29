<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<form name="frmLogin" method="post" action="${contextPath}/test/memberInfo.do">
		<h1>Member register page</h1>
		<table border="1" width="80% align="center">
			<tr align="center">
				<td>ID</td>
				<td>Password</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="id" value="" size="20"></td>
				<td><input type="password" name="pwd" value="" size="20"></td>
			</tr>
			<tr align="center">
				<td>Name</td>
				<td>email</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="name" value="" size="20"></td>
				<td><input type="text" name="email" value="" size="20"></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="Login">
					<input type="reset" value="Cancel">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>