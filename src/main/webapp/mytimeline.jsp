<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>My Timeline</title>
</head>
<body>
	<h1>Showing your timeline</h1>

	<h2><a href="funcionalidades.jsp">FUNCIONALIDADES</a></h2>
	<h2><a href="index.jsp">INDEX</a></h2>
	
	<div class="container">
	
		<p class="message">${message}</p>
				
		<table id="tweets">
			<tr>
				<th>User</th>
				<th>Text</th>
				<th>Created at</th>
				<th>Delete</th>
				<th>Analyze Sentiment</th>
			</tr>
			<c:forEach items="${requestScope.timeline}" var="status">
				<tr>
				<td><c:out value="${status.user.name}"/></td>
				<td><c:out value="${status.text}"/></td>
				<td><c:out value="${status.createdAt}"/></td>
				<c:choose>
    				<c:when test="${status.user.screenName == twitter.screenName}">
       					 <td>
				 		 <a href="statusDelete?id=${status.id}"><img src="./img/delete.png" width="30px"></a>
						</td>
    				</c:when>    
    				<c:otherwise>
        				<td></td>
    				</c:otherwise>
				</c:choose>
				<td>
					<a href="analyzeTweetSentiment?tweetanalyze=${status.text}"><img src="./img/analysis.png" width="30px"></a>
				</td>
				</tr>
			</c:forEach>			
		</table>

		<a href="/EditFile.jsp" class="button">Create new file</a>
	</div>

</body>
</html>
