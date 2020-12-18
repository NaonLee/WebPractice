<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login result 1</title>
</head>
<body>
	<c:if test="${not empty param.id}">
		<c:if test="${param.id == 'admin'}">
			<h1>Login as an administrator.</h1>
			<form>
				<input type="button" value="delete member">
				<input type="button" value="add member">
			</form>
		</c:if>
		<c:if test="${param.id != 'admin'}">
			<h1>Welcome! <c:out value="${param.id}"/>!!!</h1>
		</c:if>
	</c:if>
	
</body>
</html>