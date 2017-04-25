<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Feelthetweet - Timeline</title>
</head>
<body>
	<a href="home.jsp">HOME</a>
	<h1>Showing ${requestScope.usertl}'s timeline</h1>

	<div class="container">
	
		<!-- <p class="message">${message}</p> -->
				
		<table id="tweets">
			<tr>
				<th>User</th>
				<th>Text</th>
				<th>Created at</th>
				<th>Analyze Sentiment</th>
				<th>View user</th>
			</tr>
			<c:forEach items="${requestScope.timeline}" var="status">
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
