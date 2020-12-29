<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec02.ex01.*" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="m" class="sec02.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>
<%
	MemberDAO dao = new MemberDAO();
	dao.addMember(m);
	List list = new ArrayList();
	request.setAttribute("membersList", list);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="membersList.jsp"/>
</body>
</html>