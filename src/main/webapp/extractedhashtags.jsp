<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Feelthetweet - Extracted Hashtags</title>
</head>
<body>
	<a href="home.jsp">HOME</a>
	<h1>Extracted hashtags from the text</h1>

	<div class="trends">
	
		<!-- <p class="message">${message}</p> -->
				
		<ul id="hashtags">
			
			<c:forEach items="${requestScope.trends}" var="trend">
				
				<li>
				<c:out value="${trend}"/>
				<!--	NOT WORKING AS INTENDED 
				 <a href="twitterSearch?querytext=${trend}"><img src="./img/edit.png" width="30px"></a> -->
				</li>
				
			</c:forEach>
						
		</ul>

	</div>

</body>
</html>
