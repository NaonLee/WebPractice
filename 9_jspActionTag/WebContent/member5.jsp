<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty property="id" name="m" />
<jsp:setProperty property="pwd" name="m" />
<jsp:setProperty property="name" name="m"/>
<jsp:setProperty property="email" name="m" />
<%
	/* 
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberBean m = new MemberBean(id, pwd, name, email);
	
	m.setId(id);
	m.setPwd(pwd);
	m.setName(name);
	m.setEmail(email); */
	
	MemberDAO dao = new MemberDAO();
	dao.addMember(m);
	List membersList = dao.listMembers();
%>
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
		<%
			if(membersList.size() == 0){
		%>
		<tr>
			<td colspan="5">
				<p align="center"><b><span style="font-size:9pt;">There is no member registered.</span></b></p>
			</td>
		</tr>
		<%
			}else{
				for(int i = 0; i < membersList.size(); i++){
					MemberBean bean = (MemberBean)membersList.get(i);
		%>
					<tr align="center">
						<td>
							<%= bean.getId() %>
						</td>
						<td>
							<%= bean.getPwd() %>
						</td>
						<td>
							<%= bean.getName() %>
						</td>
						<td>
							<%= bean.getEmail() %>
						</td>
						<td>
							<%= bean.getJoinDate() %>
						</td>
					</tr>
		<%
				}
		%>
		<%
			}
		%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>