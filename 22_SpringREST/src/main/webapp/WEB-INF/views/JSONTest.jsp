<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test Home</title>
<script type="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			var member = {
				id: "Lee",
				pwd: "123",
				name: "Leedo",
				email: "leedo@gmail.com"	
			};
			$.ajax({
				type:"post",
				url: "${contextPath}/test/info",
				contentType: "application/json",
				data: JSON.stringify(member),
				
				success: function(data, textStatus){},
				error: function(data, textStatus){alert("Error!");},
				complete: function(data, textStatus){}
			});
		});
	});
	
</script>
</head>
<body>
	<input type="button" value="Send member info" id="checkJson"/><br><br>
	<div id="output"></div>
</body>
</html>