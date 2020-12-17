<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="id" value="Ryu" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'Ryujin'}" scope="page"/>
<c:set var="age" value="${21}" scope="page"/>
<c:set var="height" value="${165}" scope="page"/>
<c:remove var="age"/>
<c:remove var="height"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>using c:remove</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>age</b></td>
			<td width="20%"><b>height</b></td>
		</tr>
		<tr align="center">
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${age}</td>
			<td>${height}</td>
		</tr>
	</table>
</body>
</html>