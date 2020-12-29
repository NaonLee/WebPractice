<%@page import="sec02.ex01.*"
		import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h1 {
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>member information</title>
</head>
<body>
	<h1>Print member information</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		String _name = request.getParameter("name");
		MemberVO memberVO = new MemberVO();
		memberVO.setName(_name);
		MemberDAO dao = new MemberDAO();
		List list = dao.searchMember(memberVO);
	%>
	
	<table border=1 width=800 align=center>
		<tr align=center bgcolor="#FFFF66">
			<td>Id</td>
			<td>Password</td>
			<td>Name</td>
			<td>Email</td>
			<td>joinDate</td>
		</tr>
		
		<%
			for(int i = 0; i < list.size(); i++){
				MemberVO vo = (MemberVO)list.get(i);
				String id = vo.getId();
				String pwd = vo.getPwd();
				String name = vo.getName();
				String email = vo.getEmail();
				Date joinDate = vo.getJoinDate();
		%>
		
		<tr align=center>
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
			<td><%=joinDate %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>