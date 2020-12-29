<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="list" class="java.util.ArrayList"></jsp:useBean>
<%
	MemberBean m2 = new MemberBean("im", "1234", "임창균", "im@test.com");
	list.add(m1);
	list.add(m2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using collection</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>Email</b></td>
		</tr>
		<tr align="center">
			<td>${list[0].id}</td>
			<td>${list[0].pwd}</td>
			<td>${list[0].name}</td>
			<td>${list[0].email}</td>
		</tr>
		<tr align="center">
			<td>${list[1].id}</td>
			<td>${list[1].pwd}</td>
			<td>${list[1].name}</td>
			<td>${list[1].email}</td>
		</tr>
	</table>
</body>
</html>