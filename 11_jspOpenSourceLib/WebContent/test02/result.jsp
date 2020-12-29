<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="/jspOpenSourceLib"/>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1}"/>
<c:set var="file2" value="${param.param2}"/>
<title>Insert title here</title>
</head>
<body>

	Parameter 1:
		<c:out value="${file1}"/><br>
	Parameter 2:
		<c:out value="${file2}"/><br>
	<c:if test="${not empty file1}">
		<img src="${contextPath }/download.do?fileName=${file1}" width=300 height=300 /> <br>
	</c:if>
	<c:if test="${not empty file2}">
		<img src="${contextPath }/download.do?fileName=${file2}" width=300 height=300 /> <br>
	</c:if>
	Download file: <br>
	<a href="${contextPath}/download.do?fileName=${file2}">Download</a>
</body>
</html>