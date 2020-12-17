<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="list" class="java.util.ArrayList"/>
<jsp:useBean id="map" class="java.util.HashMap"/>
<%
	map.put("id", "shin");
	map.put("pwd", "123");
	map.put("name", "신유나");
	map.put("email", "yuna@gmail.com");
	
	MemberBean m1 = new MemberBean("hwang", "124125", "황예지", "yeji@test.com");
	MemberBean m2 = new MemberBean("choi", "esf", "최지수", "jisu@test.com");
	list.add(m1);
	list.add(m2);
	map.put("list", list);
%>

<c:set var="membersList" value="${map.list}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using useBean&c:set</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>email</b></td>
		</tr>
		<tr align="center">
			<td>${map.id}</td>
			<td>${map.pwd}</td>
			<td>${map.name}</td>
			<td>${map.email}</td>
		</tr>
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		<tr align="center">
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
	</table>
</body>
</html>