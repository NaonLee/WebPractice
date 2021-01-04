<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="result" value="${param.result }"/>
<%
   request.setCharacterEncoding("UTF-8");
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<c:choose>
	<c:when test="${result=='loginFailed'}">
		<script>
			window.onload=function(){
				alert("login failed, please login again");
			}
		</script>
	</c:when>
</c:choose>
</head>

<body>
	<form method="post" name="frmLogin" action="${contextPath}/member/login.do">
	<table border="1" width="80%" align="center">
	  <tr align="center">
	  	<td>ID</td>
	  	<td>Password</td>
	  </tr>
	  <tr align="center">
	  	<td>
	  		<input type="text" name="id" value="" size="20">
	  	</td>
	  	<td>
	  		<input type="password" name="pwd" value="" size="20">
	  	</td>
	  </tr>
	  <tr align="center">
	  	<td colspan="2">
	  		<input type="submit" value="Login">
	  		<input type="reset" value="Reset">
	  	</td>
	  </tr>
	</table>
	</form>
</body>
</html>