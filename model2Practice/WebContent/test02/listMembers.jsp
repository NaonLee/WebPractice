<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" isELIgnored="false"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members list page</title>

</head>
<body>
	<p class="cls1">Member's information</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>ID</b></td>
			<td width="7%"><b>Password</b></td>
			<td width="7%"><b>Name</b></td>
			<td width="7%"><b>Email</b></td>
			<td width="7%"><b>Joined date</b></td>
		</tr>
		
		<c:choose>
			<c:when test="${membersList == null }">
				<tr>
					<td colspan="5">
						<b>There is no member on the list</b>
					</td>
				</tr>
			</c:when>
			<c:when test="${membersList != null}">
				<c:forEach var="mem" items="${membersList}">
					<tr align="center">
						<td>${mem.id}</td>
						<td>${mem.pwd}</td>
						<td>${mem.name}</td>
						<td>${mem.email}</td>
						<td>${mem.joinDate}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="${contextPath}/test02/memberForm2.jsp"><p class="cls2">Register</p></a>
</body>
</html>