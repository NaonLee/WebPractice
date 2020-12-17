<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sec01.ex02.MemberBean"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberBean member = new MemberBean("Son", "123455555", "Shownu", "sib@tess.com");
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward2</title>
</head>
<body>
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>