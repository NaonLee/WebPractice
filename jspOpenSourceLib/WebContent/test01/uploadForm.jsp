<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File upload opensource</title>
</head>
<body>
	<c:set var="contextPath" value="/jspOpenSourceLib"/>
	<form action="${contextPath}/upload.do" method="post" enctype="multipart/form-data">
		File1: <input type="file" name="file1"><br>
		File2: <input type="file" name="file2"><br>
		Parameter1: <input type="text" name="param1"><br>
		Parameter2: <input type="text" name="param2"><br>
		Parameter3: <input type="text" name="param3"><br>
		<input type="submit" value="upload">
	</form>
</body>
</html>