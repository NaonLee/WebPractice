<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#tr_btn_modify{
		display:none;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	function fn_remove_article(url, articleNo){
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		
		var articleNoInput = document.createElement("input");
		articleNoInput.setAttribute("type", "hidden");
		articleNoInput.setAttribute("name", "articleNo");
		articleNoInput.setAttribute("value", articleNo);
		form.appendChild(articleNoInput);
		document.body.appendChild(form);
		form.submit();
	}
	
	function backToList(obj){
		obj.action="${contextPath}/board/listArticles.do";
		obj.submit();
	}
	
	function fn_enable(obj){
		if(document.getElementById("i_imageFileName") != null)
			document.getElementById("i_imageFileName").disabled = false;
		document.getElementById("i_title").disabled = false;
		document.getElementById("i_content").disabled = false;
		document.getElementById("tr_btn_modify").style.display = "block";
		document.getElementById("tr_btn").style.display = "none";
	}
	function fn_modify_article(obj){
		obj.action = "${contextPath}/board/modArticle.do";
		obj.submit();
	}
	
	function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	 function fn_reply_form(url, parentNo){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNoInput = document.createElement("input");
	     parentNoInput.setAttribute("type","hidden");
	     parentNoInput.setAttribute("name","parentNo");
	     parentNoInput.setAttribute("value", parentNo);
		 
	     form.appendChild(parentNoInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
</script>

<title>View article</title>
</head>
<body>
<form name="frmArticle" method="post" action="${contextPath}" enctype="multipart/form-data">
	<table align="center" border="0" >
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">Article No</td>
			<td>
				<input type="text" value="${article.articleNo}" disabled/>
				<input type="hidden" name="articleNo" value="${article.articleNo}"/>
			</td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">Writer ID</td>
			<td>
				<input type="text" value="${article.id}" name="id"  disabled/>
			</td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">Title</td>
			<td>
				<input type="text" value="${article.title}" name="title" id="i_title" disabled/>
			</td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">Content</td>
			<td>
				<textarea rows="20" cols="60" name="content" id="i_content" disabled>${article.content}</textarea>
			</td>
		</tr>
		
		<c:if test="${not empty article.imageFileName && article.imageFileName != 'null'}">
			<tr>
				<td width="150" align="center" bgcolor="#FF9933" rowspan="2">Image</td>
				<td>
					<input type="hidden" name="originalFileName" value="${article.imageFileName}"/>
					<img id="preview" src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNo=${article.articleNo}" height="200" width="200" /> <br>
				</td>
			</tr>
			
		</c:if>
		<tr>
				<td>
					<input type="file" name="imageFileName" id="i_imageFileName" onchange="readURL(this);" disabled/>
				</td>
			</tr>
		<tr>
			<td width="150" align="center" bgcolor="FF9933">Written Date</td>
			<td>
				<input type="text" value="<fmt:formatDate value="${article.writeDate}"/>" disabled/>
			</td>
		</tr>
		<tr id="tr_btn_modify">
			<td colspan="2" align="center">
				<input type="button" value="Apply changes" onClick="fn_modify_article(frmArticle)">
				<input type="button" value="Cancel" onClick="backToList(frmArticle)">
			</td>	
		</tr>
		

		<tr id="tr_btn">
			<td colspan=2 align=center>
				<input type="button" value="Answer" onClick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.articleNo})">
				<input type="button" value="Modify" onClick="fn_enable(this.form)">
				<input type="button" value="Delete" onClick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNo})">
				<input type="button" value="Back to list" onClick="backToList(this.form)">
				
			</td>
		</tr>
	</table>
	</form>
</body>
</html>