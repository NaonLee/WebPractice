<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result page</title>
</head>
<body>
	<h1>ID: ${id}</h1>
	<h1>PWD: ${pwd}</h1>
	<%--@ModelAttribute를 이용해 VO로 값을 읽어올 경우(login4)
	 <h1>ID: ${info.id}</h1>
	<h1>PWD: ${info.pwd}</h1> --%>		
</body>
</html>