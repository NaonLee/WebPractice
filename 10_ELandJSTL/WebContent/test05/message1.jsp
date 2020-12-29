<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL multiple languages</title>
</head>
<body>
	<fmt:setLocale value="en-US"/>
	
	 <%-- <fmt:setLocale value="ko_KR"/> --%>
	 <h1>
	 	Member info<br><br>
	 	<fmt:bundle basename="resource.member">
	 		Name: <fmt:message key="mem.name"/><br>
	 		Address: <fmt:message key="mem.address"/><br>
	 		Occupation: <fmt:message key="mem.job"/><br>
	 	</fmt:bundle>
	 </h1>
</body>
</html>