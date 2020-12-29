<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
	List list = new ArrayList();

	MemberBean m1 = new MemberBean("hwang", "124125", "황예지", "yeji@test.com");
	MemberBean m2 = new MemberBean("choi", "esf", "최지수", "jisu@test.com");
	MemberBean m3 = new MemberBean("shin", "123", "신유나", "yuna@gmail.com");
	
	list.add(m1);
	list.add(m2);
	list.add(m3);
%>

<c:set var="membersList" value="<%=list%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print arrayList using c:forEach 2</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%"><b>Id</b></td>
			<td width="20%"><b>Pwd</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>email</b></td>
		</tr>
		<c:forEach var="member" items="${membersList}">
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>