<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%!
	String msg = "You did not enter an id. Please enter the id.";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result page</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		if(id.length() == 0){
			/*
			RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.forward(request, response);
			*/		
	%>
		<jsp:forward page="login2.jsp">
			<jsp:param value="<%=msg %>" name="msg"/>
		</jsp:forward>
	<%
		}
	%>
	<h1>Hello <%=id %>!</h1>
</body>
</html>