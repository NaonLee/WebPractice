<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function (){
			var jsonStr = '{"name": "황예지", "age": "21", "gender": "F", "nickname": "예지"}';
			var jsonObj = JSON.parse(jsonStr);
			var output = "MemberList<br>===========<br>";
			
			output += "Name: " + jsonObj.name + "<br>";
			output += "Age: " + jsonObj.age + "<br>";
			output += "Gender: " + jsonObj.gender + "<br>";
			output += "Nickname: " + jsonObj.nickname + "<br>";
			
			$("#output").html(output);
		});
	});
</script>
<title>JSon practice 3</title>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">Print</a><br><br>
	<div id="output"></div>
</body>
</html>