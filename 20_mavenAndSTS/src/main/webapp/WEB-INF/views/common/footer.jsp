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
<style>
p {
	font-size:20px;
	text-align:center;
}
</style>

<title>footer</title>
</head>
<body>
	<p>e-mail: admin.test.com</p>
	<p>Address: Suwon-si</p>
	<p>Map: <a href="#">Map</a> </p>
</body>
</html>