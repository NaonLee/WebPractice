<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:Redirect practice</title>
</head>
<body>
	<c:redirect url="/test01/member1.jsp">
	<c:param name="id" value="Hwang"/>
	<c:param name="pwd" value="124124"/>
	<c:param name="name" value="황예지"/>
	<c:param name="email" value="Yegi@test.com"/>
</c:redirect>

</body>
</html>