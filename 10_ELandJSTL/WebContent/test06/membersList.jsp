<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec02.ex01.MemberBean" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members list</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%">Id</td>
			<td width="7%">Password</td>
			<td width="7%">Name</td>
			<td width="7%">Email</td>
			<td width="7%">Joined date</td>
		</tr>
		<c:choose>
			<c:when test="${membersList==null}">
				<tr>
					<td colspan="5">
						<b>No member registered.</b>
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
</body>
</html>