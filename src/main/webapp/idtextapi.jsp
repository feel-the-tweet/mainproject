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
  ${message}<br>
  ${exception.message}<p>
  
   <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp centered-c" id="files">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Id</th>
      <th class="mdl-data-table__cell--non-numeric">Text</th>
      <th class="mdl-data-table__cell--non-numeric">Analysis</th>
    </tr>
  </thead>
  <tbody>
 
		<tr>
		<td class="mdl-data-table__cell--non-numeric"><c:out value="${requestScope.texto.id}"/></td>
		<td class="mdl-data-table__cell--non-numeric"><c:out value="${requestScope.texto.content}"/></td>
		<td class="mdl-data-table__cell--non-numeric"><c:out value="${requestScope.texto.sentiment}"/></td>
		</tr>
	
  </tbody>
</table>
<p><p>
	<input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="button" onclick="location.href='indexapi.jsp'" value="Volver"/>
</body>
</html>