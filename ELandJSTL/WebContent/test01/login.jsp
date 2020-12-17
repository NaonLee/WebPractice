<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<form action="result.jsp">
		Id: <input type="text" name="id">
		Password: <input type="password" name="pwd">
		<input type="submit" value="submit"/><input type="reset" value="reset"/> 
	</form>
	<br><br>
	<a href="http://localhost:8090/ELandJSTL/test01/memberForm.jsp">Registration</a>
	<a href="<%=request.getContextPath() %>/test01/memberForm.jsp">Registration</a>
	<a href="${pageContext.request.contextPath}/test01/memberForm.jsp">Registration</a>
</body>
</html>