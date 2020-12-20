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
				url: "http://localhost:8090/jqueryPractice/json3",
				success: function(data, textStatus){
					var jsonInfo = JSON.parse(data);
					var memberInfo = "Members' information<br>==============<br>";
					
					for(var i in jsonInfo.members){
						memberInfo += "Name: " + jsonInfo.members[i].name + "<br>";
						memberInfo += "Age: " + jsonInfo.members[i].age + "<br>";
						memberInfo += "Gender: " + jsonInfo.members[i].gender + "<br>";
						memberInfo += "Nickname: " + jsonInfo.members[i].nickname + "<br>";
					}

					var booksInfo = "<br><br><br>Books' information<br>==============<br>";
					for(var i in jsonInfo.books){
						booksInfo += "Title: " + jsonInfo.books[i].title + "<br>";
						booksInfo += "Writer: " + jsonInfo.books[i].writer + "<br>";
						booksInfo += "Price: " + jsonInfo.books[i].price + "<br>";
						booksInfo += "Genre: " + jsonInfo.books[i].genre + "<br>";
						
						imageURL = jsonInfo.books[i].image;
						booksInfo += "<img height='100' src='" + imageURL + "'/> <br><br>";
					}
					$("#output").html(memberInfo + "<br>" + booksInfo);
				},
				error: function(data, textStatus){ alert("Error has been occurred"); },
				complete: function(data, textStatus){ alert("complete"); }
			});
		});
	});
</script>
<title>JSon practice 7</title>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">Print</a><br><br>
	<div id="output"></div>
</body>
</html>