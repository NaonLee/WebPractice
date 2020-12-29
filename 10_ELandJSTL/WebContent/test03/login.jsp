<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using c:set for contextPath</title>
</head>
<body>
	<form action="result.jsp">
		Id: <input type="text" name="id">
		Password: <input type="password" name="pwd">
		<input type="submit" value="submit"/><input type="reset" value="reset"/> 
	</form>
	<br><br>
	<a href="${contextPath}/test03/memberForm.jsp">Registration</a>
	<a href="http://localhost:8090/ELandJSTL/test03/memberForm.jsp">Registration</a>
	<a href="<%=request.getContextPath() %>/test03/memberForm.jsp">Registration</a>
	<a href="${pageContext.request.contextPath}/test03/memberForm.jsp">Registration</a>
</body>
</html>