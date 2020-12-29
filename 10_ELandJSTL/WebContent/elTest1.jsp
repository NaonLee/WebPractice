<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data using for Expression Language</title>
</head>
<body>
	<h1>Print data by EL</h1>
	<h1>
		\${100}: ${100}<br>
		\${"Hello"}: ${"Hello"}<br>
		\${10+1}: ${10+1}<br>
		\${"10"+1}: ${"10"+1}<br>
		
		<%-- \${null+10}: ${null+10}<br> --%>
		<%--\${"Hello" + 11}: ${"Hello"+11}<br>--%>
		<%--\${"hello"+"world"}: ${"hello"+"world"}<br> --%>
	</h1>
</body>
</html>