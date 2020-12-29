<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:out practice-print page</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>email</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty param.id}">
				<tr>
					<td colspan="4">Please enter the id.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td><c:out value="${param.id}"/></td>
					<td>$<c:out value="${param.pwd}"/></td>
					<td><c:out value="${param.name}"/></td>
					<td><c:out value="${param.email}"/></td>
				</tr>
			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>