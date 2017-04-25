<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Feelthetweet - Edit/New File</title>
</head>
<body>

<% String controller = "GoogleDriveFileNew"; %>
	
	<c:if test="${not empty file}">
    	<% controller = "GoogleDriveFileUpdate"; %>
	</c:if>

	<div class="container">
	
		<p class="message">${message}</p>
				
		<form action="<%= controller %>" method="post">
			<c:if test="${not empty file}">
				<input type="hidden" name="id" value="${file.id}">
			</c:if>
			File name: <input type="text" name="title" 
							<c:if test="${not empty file}">
								disabled="true" 
								value="${file.title}"
								</c:if>
								><br>
			Content: <textarea name="content">${content}</textarea>
			<br>
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='contactlist'" class="button">Cancel</button>
			</div>
		</form>
	</div>
</body>
</html>
