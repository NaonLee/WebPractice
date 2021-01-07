<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test 2</title>
<script type="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			var member = {
				articleNO:"112",
				writer:"Yuna",
				title:"Hello",
				content:"Product information"
			};
			$.ajax({
				//add
				type:"post",
				url: "${contextPath}/boards",
				//update
				//type:"PUT",
				//url:"${contextPath}/boards/112",
				contentType:"application/json",
				data:JSON.stringify(article),
				
				success:function(data, textStatus){
					alert(data);
				},
				error: function(data, textStatus){
					alert("Error!");
				},
				complete: function(data, textStatus){
					
				}
			});	//end ajax
		});
	});
	
</script>
</head>
<body>
	<input type="button" value="Write" id="checkJson"/><br><br>
	<div id="output"></div>
</body>
</html>