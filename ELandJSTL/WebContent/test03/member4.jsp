<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="id" value="Ryu" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'Ryujin'}" scope="page"/>
<c:set var="age" value="${21}" scope="page"/>
<c:set var="height" value="${165}" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:if practice</title>
</head>
<body>
	<c:if test="${true}">
		<h1>Always true</h1>
	</c:if>
	<c:if test="${false}">
		<h1>Always false</h1>
	</c:if>
	<c:if test="${11 == 11}">
		<h1>They are the same</h1>
	</c:if>
	<c:if test="${11 != 31}">
		<h1>They are not the same</h1>
	</c:if>
	<c:if test="${(id=='Ryu')&&(name=='Ryujin')}">
		<h1>Id is ${id} and the name is ${name}</h1>
	</c:if>
	<c:if test="${21==age}">
		<h1>Age is ${age}</h1>
	</c:if>
	<c:if test="${height>160}">
		<h1>${name}'s height is greater than 160.</h1>
	</c:if>
	
</body>
</html>