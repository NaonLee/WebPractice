<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty property="name" name="m1" value="여환웅"/>
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data using for Expression Language</title>
</head>
<body>
	<h1>Print various operators</h1>
	Empty operator
	<h2>
		\${empty m1}: ${empty m1}<br>
		\${not empty m1}: ${not empty m1}<br>
		
		\${empty m2}: ${empty m2}<br>
		\${not empty m2}: ${not empty m2}<br>
		
		\${empty "hello"}: ${empty "hello"}<br>
		\${empty null}: ${empty null}<br>
		\${empty ""}: ${empty ""}<br>
	</h2>
</body>
</html>