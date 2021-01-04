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
	.no-underline{
		text-decoration: none;
	}
</style>
<title>Side menu</title>
</head>
<body>
	<h1>Side menu</h1>
	<h1>
		<a href="#" class="no-underline">Manage member</a><br>
		<a href="#" class="no-underline">Manage content</a><br>
		<a href="#" class="no-underline">Manage product</a><br>
	</h1>
	
	
</body>
</html>