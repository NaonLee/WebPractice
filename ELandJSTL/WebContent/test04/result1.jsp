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
	<c:if test="${empty param.id}">
		Enter an id.<br>
		<a href='login.jsp'>Login</a>
	</c:if>
	<c:if test="${not empty param.id}">
		<h1>Welcome! <c:out value="${param.id}"/>!!!</h1>
	</c:if>
</body>
</html>