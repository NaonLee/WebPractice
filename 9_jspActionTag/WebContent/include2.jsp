<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include2.jsp</title>
</head>
<body>
<jsp:include page="giraffe_image.jsp" flush="true">
		<jsp:param value="giraffe2" name="name"/>
		<jsp:param value="giraffe2.jpg" name="imgName"/>
	</jsp:include>
</body>
</html>