<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Extracted Hashtags</title>
</head>
<body>
	<h1>Extracted hashtags from the text</h1>

	<h2><a href="funcionalidades.jsp">FUNCIONALIDADES</a></h2>
	<h2><a href="index.jsp">INDEX</a></h2>

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
