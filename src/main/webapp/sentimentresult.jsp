<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Feelthetweet - Sentiment Analysis Result</title>
</head>
<body>

	<h1>Sentiment Analysis Result</h1>
	
	<h2><a href="home.jsp">HOME</a></h2>
	<h2><a href="index.jsp">INDEX</a></h2>
	
	<div class="sentimentresult">
	
		<!-- <p class="message">${message}</p> -->
				
		<table id="sentimentres">
		
			<tr>
				<th>Polarity</th>
				<th>Polarity Confidence</th>
				<th>Subjectivity</th>
				<th>Subjectivity Confidence</th>
			</tr>
			
			<tr>
				<td>${sentiment.polarity}</td>
				<td>${sentiment.polarityConfidence}</td>
				<td>${sentiment.subjectivity}</td>
				<td>${sentiment.subjectivityConfidence}</td>
			</tr>		
			
		</table>
		
	</div>

</body>
</html>
