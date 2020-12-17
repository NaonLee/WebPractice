<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:url var="url1" value="/test01/member1.jsp">
	<c:param name="id" value="Hwang"/>
	<c:param name="pwd" value="124124"/>
	<c:param name="name" value="황예지"/>
	<c:param name="email" value="Yegi@test.com"/>
</c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:url, c:param practice</title>
</head>
<body>
	<%-- <a href='${contextPath}/test01/member1.jsp'>Print member list</a>--%>
	<a href='${url1}'>Print member list</a>
</body>
</html>