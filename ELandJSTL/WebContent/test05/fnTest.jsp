<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fn practice</title>
</head>
<body>
	<c:set var="title1" value="hello world!"/>
	<c:set var="title2" value="The centre of mall JSP!"/>
	<c:set var="str1" value="centre"/>
	<h2>various string function</h2>
	title1="hello world"<br>
	title2="The centre of mall JSP!"<br>
	str1="centre"<br><br>
	
	fn:length(title1)=${fn:length(title1) }<br>
	fn:toUpperCase(title1)=${fn:toUpperCase(title1) }<br>
	fn:toLowerCase(title1)=${fn:toLowerCase(title1) }<br><br>
	
	fn:substring(title1, 3, 6)= ${fn:substring(title1, 3, 6) }<br>
	fn:trim(title1)=${fn:trim(title1) }<br>
	fn:replace(title1, " ", "/")=${fn:replace(title1, " ", "/") }<br><br>
	
	fn:indexOf(title2,str1)=${fn:indexOf(title2,str1)}<br>
	fn:contains(title1,str1)=${fn:contains(title1,str1)}<br>
	fn:contains(title2,str1)=${fn:contains(title2,str1)}<br>
	
	
</body>
</html>