<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Converted score</title>
</head>
<body>
	<h1>Score <%=score %></h1><br>
	<%
	if(score >= 90){
	%>
	<h1>A</h1>
	<%
	} else if(score >= 80 && score < 90){
	%>
	<h1>B</h1>
	<%
	} else if(score >= 70 && score < 80){
	%>
	<h1>C</h1>
	<%
	} else{
	%>
	<h1>F</h1>
	<%
	}
	%>
	<br>
	<a href="2_scoreTest.html">Enter the score</a>
</body>
</html>