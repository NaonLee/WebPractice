<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	
<title>View article</title>
</head>
<body>
<form name="frmArticle" method="get" action="${contextPath}" enctype="multipart/form-data">
	<table align="center" border="0" >
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">Article No</td>
			<td>
				<input type="text" value="${article.articleNo}" name="articleNo" id="i_articleNo" disabled/>
			</td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">Writer ID</td>
			<td>
				<input type="text" value="${article.id}" name="writerId" id="i_writerId" disabled/>
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
					<img src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNo=${article.articleNo}" id="preview"/> <br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="file" name="imageFileName" id="i_imageFileName" disabled/>
				</td>
			</tr>
		</c:if>
		<tr>
			<td width="20%" align="center" bgcolor="FF9933">Written Date</td>
			<td>
				<input type="text" value="<fmt:formatDate value="${article.writeDate}"/>" disabled/>
			</td>
		</tr>
		<tr><td colspan=2><br><br></td></tr>
		<tr id="tr_btn">
			<td colspan=2 align=center>
				<input type="button" value="Modify">
				<input type="button" value="Delete">
				<input type="button" value="Back to list"/>
				<input type="button" value="Answer">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>