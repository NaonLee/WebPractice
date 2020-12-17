<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sec01.ex02.MemberBean, java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	List list = new ArrayList();
	MemberBean m1 = new MemberBean("Son1", "123455555", "Shownu1", "sib1@tess.com");
	MemberBean m2 = new MemberBean("Son2", "23455555", "Shownu2", "sib2@tess.com");
	
	list.add(m1);
	list.add(m2);
	request.setAttribute("membersList", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward3</title>
</head>
<body>
	<jsp:forward page="member3.jsp"></jsp:forward>
</body>
</html>