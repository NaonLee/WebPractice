<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty property="*" name="m"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member list</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">Id</td>
			<td width="7%">pwd</td>
			<td width="5%">name</td>
			<td width="11%">email</td>
			<td width="5%">Join date</td>
		</tr>

		<tr align="center">
			<td>
				<jsp:getProperty property="id" name="m"/>
			</td>
			<td>
				<jsp:getProperty property="pwd" name="m"/>
			</td>
			<td>
				<jsp:getProperty property="name" name="m"/>
			</td>
			<td>
				<jsp:getProperty property="email" name="m"/>
			</td>
		</tr>
		
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>