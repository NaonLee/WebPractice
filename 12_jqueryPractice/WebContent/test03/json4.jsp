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
			var jsonStr = '{"members": [{"name": "황예지", "age": 21, "gender": "F", "nickname":"예지"}' + 
				', {"name": "신류진", "age": 20, "gender": "F", "nickname":"류진"}]}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "MemberList<br>===========<br>";
			
			for(var i in jsonInfo.members){
				output += "Name: " + jsonInfo.members[i].name + "<br>";
				output += "Age: " + jsonInfo.members[i].age + "<br>";
				output += "Gender: " + jsonInfo.members[i].gender + "<br>";
				output += "Nickname: " + jsonInfo.members[i].nickname + "<br><br>";
			}
			
			$("#output").html(output);
		});
	});
</script>
<title>JSon practice 4</title>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">Print</a><br><br>
	<div id="output"></div>
</body>
</html>