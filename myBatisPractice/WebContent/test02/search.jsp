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
	<form action="${contextPath}/mem3.do">
		Input: <input type="text" name="value"/>
		<select name="action">
			<option value="listMembers">All</option>
			<option value="selectMemberById">ID</option>
			<option value="selectMemberByPwd">Password</option>
		</select><br>
		<input type="submit" value="Search"/>
	</form>
</body>
</html>