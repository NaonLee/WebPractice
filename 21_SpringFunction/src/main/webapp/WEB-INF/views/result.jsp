<%@ page language="java" contentType="text/html; charset=UTF-8" 
	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta "charset=UTF-8">
	<title>Result page</title>
</head>
<body>
	<h1>Successfully uploaded.</h1>
	<label>아이디:</label>
	 <input type="text" name="id" value="${map.id }" readonly><br>
	<label>이름:</label>
	 <input type="text" name="name" value="${map.name }" readonly><br>
	 <div class="result-images">
	 	<c:forEach var="imageFileName" items="${map.fileList}">
	 		<img src="${pageContext.request.contextPath }/download?imageFileName=${imageFileName }">
			<br><br><br>
	 	</c:forEach>
	 </div>
	 
	 <p><a href="${pageContext.request.contextPath}/form">Upload again</a></p>
</body>
</html>
