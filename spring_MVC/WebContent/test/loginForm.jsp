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
	<form name="frmLogin" method="post" action="${contextPath}/test/login.do">
		<table border="1" width="80% align="center">
			<tr align="center">
				<td>ID</td>
				<td>Password</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="userID" value="" size="20"></td>
				<td><input type="password" name="pwd" value="" size="20"></td>
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