<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        
<title>API TEXTS</title>
</head>
<body>

	<input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="button" onclick="location.href='GetTextsServlet'" value="Get All Texts"/>
	<p><p>
	
	<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp centered-c" id="files">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Functionality</th>
    </tr>
  </thead>
  <tbody>
  
		<tr>
		<td class="mdl-data-table__cell--non-numeric">Get Text by ID</td>
		<td class="mdl-data-table__cell--non-numeric">	<form action="GetTextIdServlet" method="post">
Id: <input id="id" name="id" type="text" required="required"></input> 
	<input type="submit" name="submit" value="Submit">
</form><p></td>
		</tr>
		<tr>
		<td class="mdl-data-table__cell--non-numeric">Create New Text</td>
		<td class="mdl-data-table__cell--non-numeric"><form action="PostTextServlet" method="post">
Title: <input id="title" name="title" type="text" required="required"></input>
Content: <input id="content" name="content" type="text" required="required"></input> 
	<input type="submit" name="submit" value="Submit">
</form></td>
		<tr>
		<td class="mdl-data-table__cell--non-numeric">Delete Text by ID</td>
		<td class="mdl-data-table__cell--non-numeric">	<form action="DeleteTextServlet" method="post">
Id: <input id="id" name="id" type="text" required="required"></input> 
	<input type="submit" name="submit" value="Submit">
</form></td>
		</tr>
			<tr>
		<td class="mdl-data-table__cell--non-numeric">Edit Text</td>
		<td class="mdl-data-table__cell--non-numeric"><form action="UpdateTextServlet" method="post">
Id: <input id="id" name="id" type="text" required="required"></input> 
Title: <input id="title" name="title" type="text" required="required"></input>
Content: <input id="content" name="content" type="text" required="required"></input> 
	<input type="submit" name="submit" value="Submit">
</form></td>
		</tr>
	
  </tbody>
</table>
<p><p>
<input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="button" onclick="window.location='http://www.feelthetweet.appspot.com'" value="Mashup Feelthetweet"/>

</body>
</html>