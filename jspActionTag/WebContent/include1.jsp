<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
	Hello it's JSP!
	<br>
	<jsp:include page="giraffe_image.jsp" flush="true">
		<jsp:param value="giraffe" name="name"/>
		<jsp:param value="giraffe1.jpg" name="imgName"/>
	</jsp:include>
	<br>
	Hello this is end of JSP!
</body>
</html>