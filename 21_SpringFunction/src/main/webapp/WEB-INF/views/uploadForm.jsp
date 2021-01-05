<%@ page language="java" contentType="text/html; charset=UTF-8" 
	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta "charset=UTF-8">
	<title>Upload page</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	var cnt = 1;
	function fn_addFile(){
		$("#d_file").append("<br>"+"<input  type='file' name='file"+cnt+"' />");
		cnt++;
	}
</script>
</head>
<body>
	<h1>Upload files</h1>
	<form method="post" action="${contextPath}/upload" enctype="multipart/form-data">
		<label>ID:</label>
		<input type="text" name="id"><br>
		<label>Name:</label>
		<input type="text" name="name"><br>
		
		<input type="button" value="add file" onClick="fn_addFile()"/><br>
		<div id="d_file"></div>
		
		<input type="submit" value="upload">
	</form>
</body>
</html>
