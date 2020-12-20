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
			$.ajax({
				type: "post",
				async: false,
				url: "http://localhost:8090/jqueryPractice/json2",
				success: function(data, textStatus){
					var jsonInfo = JSON.parse(data);
					var memberInfo = "Member Information<br>==============<br>";
					
					for(var i in jsonInfo.members){
						memberInfo += "Name: " + jsonInfo.members[i].name + "<br>";
						memberInfo += "Age: " + jsonInfo.members[i].age + "<br>";
						memberInfo += "Gender: " + jsonInfo.members[i].gender + "<br>";
						memberInfo += "Nickname: " + jsonInfo.members[i].nickname + "<br><br>";
					}
					
					$("#output").html(memberInfo);
				},
				error: function(data, textStatus){ alert("Error has been occurred"); },
				complete: function(data, textStatus){ alert("complete"); }
			});
		});
	});
</script>
<title>JSon practice 6</title>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">Print</a><br><br>
	<div id="output"></div>
</body>
</html>