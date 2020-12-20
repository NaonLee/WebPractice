<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member modification page</title>
	<style>
		.cls1{
			font-size: 40px;
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Member's information modification</h1>
	<form method="post" action="${contextPath}/member/modMember.do?id=${memberInfo.id}">
		<table align="center">
			<tr>
				<td width="200"><p align="right">ID</p></td>
				<td width="400"><input type="text" name="id" value="${memberInfo.id}" disabled></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Password</p></td>
				<td width="400"><input type="password" name="pwd" value="${memberInfo.pwd}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Name</p></td>
				<td width="400"><input type="text" name="name" value="${memberInfo.name}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Email</p></td>
				<td width="400"><input type="text" name="email" value="${memberInfo.email}"/></td>
			</tr>
			<tr>
				<td width="200"><p align="right">Joined Date</p></td>
				<td width="400"><input type="text" name="joinDate" value="${memberInfo.joinDate}" disabled/></td>
			</tr>
			<tr align="center">
				<td colspan="2" width="400"><input type="submit" value="Modify">
					<input type="reset" value="Reset"></td>
			</tr>

		</table>
	</form>
</body>
</html>