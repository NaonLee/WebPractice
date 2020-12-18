<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formatting tag library</title>
</head>
<body>
	<h2>Example of formatting tag using number</h2>
	<c:set var="price" value="100000000"/>
	<fmt:formatNumber value="${price}" type="number" var="priceNumber"/><br>
	currency:
		<fmt:formatNumber type="currency" currencySymbol="$" value="${price}" groupingUsed="true"/><br>
	Percent:
		<fmt:formatNumber type="percent" value="${price}" groupingUsed="false"/><br>
	Normal number: ${priceNumber} <br>
	
	<h2>Example of formatDate</h2>
	<c:set var="now" value="<%=new Date() %>" />
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${now}" type="time"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:formatDate value="${now}" pattern="YYYY-MM-dd :hh:mm:ss"/><br>
	
	<br><br>
	Korea current time:
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br><br>
	
	<fmt:timeZone value="America/New York">
	New york current time:
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	</fmt:timeZone>
</body>
</html>