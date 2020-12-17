<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Special symbols</title>
</head>
<body>
	<h2>escapeXml conversion</h2>
	<h2>
		<Pre>
			<c:out value="&lt;" escapeXml="true"></c:out>
			<c:out value="&lt;" escapeXml="false"></c:out>
			<c:out value="&gt;" escapeXml="true"></c:out>
			<c:out value="&gt;" escapeXml="false"></c:out>
			<c:out value="&amp;" escapeXml="true"></c:out>
			<c:out value="&amp;" escapeXml="false"></c:out>
			<c:out value="&#039;" escapeXml="true"></c:out>
			<c:out value="&#039;" escapeXml="false"></c:out>
			<c:out value="&#034;" escapeXml="true"></c:out>
			<c:out value="&#034;" escapeXml="false"></c:out>
		</Pre>
	</h2>
</body>
</html>