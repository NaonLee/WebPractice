<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member search page</title>
</head>
<body>
	<form action="${contextPath}/mem4.do">
		<input type="hidden" name="action" value="searchMember"/>
		Name: <input type="text" name="name"><br>
		Email: <input type="text" name="email"><br>
		<input type="submit" value="search"/>
	</form>
</body>
</html>