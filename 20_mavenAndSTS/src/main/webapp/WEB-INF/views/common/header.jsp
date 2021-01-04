<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<table border=0 width="100%">
		<tr>
			<td>
				<a href="${contextPath}/main.do">
					<img src="${contextPath}/resources/image/ch.PNG"/>
				</a>
			</td>
			<td>
				<h1><font size=30>Spring practice hompage</font></h1>
			</td>
			
			<td>
				<!-- if member is logon, show the member info and logout -->
				<c:choose>
					<c:when test="${isLogOn == true && member != null }">
						<h3>Welcom! ${member.name}</h3>
						<a href="${contextPath}/member/logout.do"><h3>Logout</h3></a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/loginForm.do"><h3>Login</h3></a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>