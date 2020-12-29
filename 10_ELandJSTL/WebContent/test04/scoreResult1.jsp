<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="score" value="${param.score}"/>
	
	<c:choose>
		<c:when test="${score >= 90 && score <= 100}">
			<h1>Grade is A.</h1>
		</c:when>
		<c:when test="${score >= 80 && score <= 90}">
			<h1>Grade is B.</h1>
		</c:when>
		<c:when test="${score >= 70 && score <= 80}">
			<h1>Grade is C.</h1>
		</c:when>
		<c:otherwise>
			<h1>Grade is F.</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>