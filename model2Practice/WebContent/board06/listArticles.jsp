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
		.cls1{
		text-decoration: none;}
		.cls2{
		text-align: center;
		font-size: 30px;}
	</style>
<title>Article list</title>
</head>
<body>
	<table align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightgreen">
			<td>Article No</td>
			<td>Writer</td>
			<td>Title</td>
			<td>Write date</td>
		</tr>
		<c:choose>
			<c:when test="${articlesList == null}">
				<tr height="10">
					<td colspan="4">
						<p align="center">
							<b><span style="font-size:9pt;">There is no article.</span></b>
						</p>
					</td>
				</tr>
			</c:when>
			<c:when test="${articlesList != null}">
				<c:forEach var="article" items="${articlesList}" varStatus="articleNum">
					<tr align="center">
					<td width="%5">${article.articleNo}</td>
						<td width="%10">${article.id}</td>
						<td align="left" width="35%">
							<span style="padding-right: 30px"></span>
							<c:choose>
								<c:when test='${article.level > 1}'>
									<c:forEach begin="1" end="${article.level}" step="1">
										<span style="padding-left:20px"></span>
									</c:forEach>
									<span style="font-size:12px;">[Answer]</span>
									<a class='cls1' href='${contextPath}/board/viewArticle.do?articleNo=${article.articleNo}'>${article.title}</a>
								</c:when>
								<c:otherwise>
									<a class='cls1' href='${contextPath}/board/viewArticle.do?articleNo=${article.articleNo}'>${article.title}</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td width="10%">
							<fmt:formatDate value="${article.writeDate}"/>
						</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a class="cls1" href="${contextPath}/board/articleForm.do"><p class="cls2">Write</p></a>
</body>
</html>