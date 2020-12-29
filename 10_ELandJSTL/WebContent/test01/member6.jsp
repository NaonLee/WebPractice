<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex02.*"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex02.MemberBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>
<jsp:useBean id="addr" class="sec01.ex02.Address"></jsp:useBean>
<jsp:setProperty property="city" name="addr" value="수원"/>
<jsp:setProperty property="zipcode" name="addr" value="12345"/>
<%
	m.setAddr(addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using has-a</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%"><b>Id</b></td>
			<td width="7%"><b>Pwd</b></td>
			<td width="5%"><b>Name</b></td>
			<td width="5%"><b>Email</b></td>
			<td width="5%"><b>City</b></td>
			<td width="5%"><b>Zipcode</b></td>
		</tr>
		<tr align="center">
			<td>${m.id}</td>
			<td>${m.pwd}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
			<td><%=m.getAddr().getCity() %></td>
			<td><%=m.getAddr().getZipcode() %></td>
		</tr>
		<tr align="center">
			<td>${m.id}</td>
			<td>${m.pwd}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
			<td>${m.addr.city }</td>
			<td>${m.addr.zipcode }</td>
		</tr>
	</table>
</body>
</html>