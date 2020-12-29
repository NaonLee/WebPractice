<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#checkJson").click(function(){
		var jsonStr = '{"name": ["Ryu", "Hwang", "Choi"]}';
		var jsonInfo = JSON.parse(jsonStr);
		var output = "member's name<br>";
		output += "==========<br>";
		
		for(var i in jsonInfo.name){
			output += jsonInfo.name[i] + "<br>";
		}
		
		$("#output").html(output);
	});
});
</script>
<title>JSon practice 1</title>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">Print</a><br><br>
	<div id="output"></div>
</body>
</html>