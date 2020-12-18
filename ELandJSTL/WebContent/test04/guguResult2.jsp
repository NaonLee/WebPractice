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
	<c:set var="dan" value="${param.dan}"/>
	
	<table border="1" width="800" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td colspan="2">
				Print <c:out value="${dan }"/>dan
			</td>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<c:if test="${i % 2 == 0}">
				<tr align="center" bgcolor="#CCFF66">
			</c:if>
			<c:if test="${i % 2 == 1}">
				<tr align="center" bgcolor="#CCCCFF">
			</c:if>
					<td width="400">
						<c:out value="${dan}"/> * <c:out value="${i}"/>
					</td>
					<td width="400">
						<c:out value="${dan*i}"/>
					</td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>