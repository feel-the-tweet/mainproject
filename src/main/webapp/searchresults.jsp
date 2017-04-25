<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Feelthetweet - Twitter Search Results</title>
</head>
<body>

	<h1>Twitter Search Results</h1>
	
	<h2><a href="home.jsp">HOME</a></h2>
	<h2><a href="index.jsp">INDEX</a></h2>
	
	<div class="searchresults">
	
		<!-- <p class="message">${message}</p> -->
				
		<table id="tweets">
			<tr>
				<th>User</th>
				<th>Text</th>
				<th>Created at</th>
				<th>Analyze Sentiment</th>
				<th>View user</th>
			</tr>
			<c:forEach items="${requestScope.query}" var="status">
				<tr>
				<td><c:out value="${status.user.name}"/></td>
				<td><c:out value="${status.text}"/></td>
				<td><c:out value="${status.createdAt}"/></td>
				<td>
					<a href="analyzeTweetSentiment?tweetanalyze=${status.text}"><img src="./img/edit.png" width="30px"></a>
				</td>
				<td>
				  <a href="https://twitter.com/${status.user.screenName}"><img src="./img/delete.png" width="30px"></a>
				</td>
				</tr>
			</c:forEach>			
		</table>
		
	</div>

</body>
</html>
