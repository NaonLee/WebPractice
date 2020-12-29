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
			var _jasonInfo = '{"name": "최유나", "age": 19, "gender": "F", "nickname": "유나"}';
			$.ajax({
				type: "post",
				async: false,
				url: "http://localhost:8090/jqueryPractice/json",
				data: {jsonInfo: _jasonInfo},
				success: function(data, textStatus){},
				error: function(data, textStatus){ alert("Error has been occurred"); },
				complete: function(data, textStatus){ alert("complete"); }
			});
		});
	});
</script>
<title>JSon practice 5</title>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">Print</a><br><br>
	<div id="output"></div>
</body>
</html>