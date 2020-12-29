<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File download opensource</title>
</head>
<body>
	<c:set var="contextPath" value="/jspOpenSourceLib"/>
	
	<form action="result.jsp" method="post">
		<input type="hidden" name="param1" value="1.jpg"/> <br>
		<input type="hidden" name="param2" value="2.jpg"/> <br>
		<input type="submit" value="download">
	</form>
</body>
</html>