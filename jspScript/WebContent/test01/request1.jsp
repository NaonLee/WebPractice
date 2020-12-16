<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "Leedo");
	request.setAttribute("address", "수원시 영통구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit object request 1</title>
</head>
<body>
	<%
		RequestDispatcher dispatcher = request.getRequestDispatcher("request2.jsp");
		dispatcher.forward(request, response);
	%>
</body>
</html>