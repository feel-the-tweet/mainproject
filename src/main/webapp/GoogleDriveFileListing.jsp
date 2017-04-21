<%@include file="includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Files in your Drive</h1>

	<div class="container">
	
		<p class="message">${message}</p>
				
		<table id="files">
			<tr>
				<th>Name</th>
				<th>Size</th>
				<th>Last modification date</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.files.items}" var="file">
				<tr>
				<td><c:out value="${file.title}"/></td>
				<td><c:out value="${file.fileSize}"/></td>
				<td><c:out value="${file.modifiedDate}"/></td>
				<td>
				  <a href="GoogleDriveFileUpdate?id=${file.id}"><img src="./img/edit.png" width="30px"></a>
				</td>
				<td>
					<a href="GoogleDriveFileDelete?id=${file.id}"><img src="./img/delete.png" width="30px"></a>
				</td>
				</tr>
			</c:forEach>			
		</table>
		<p>
		<a href="/EditFile.jsp" class="button">Create new plain text file</a>
	</div>

<%@include file="includes/footer.jsp"%>
