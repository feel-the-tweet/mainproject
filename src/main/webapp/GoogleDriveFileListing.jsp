<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Favicons y miniaturas para Movil -->
        <link rel="apple-touch-icon" sizes="180x180" href="favicons/apple-touch-icon.png">
        <link rel="icon" type="image/png" href="favicons/favicon-32x32.png" sizes="32x32">
        <link rel="icon" type="image/png" href="favicons/favicon-16x16.png" sizes="16x16">
        <link rel="manifest" href="favicons/manifest.json">
        <link rel="mask-icon" href="favicons/safari-pinned-tab.svg" color="#5b7dd5">
        <link rel="shortcut icon" href="favicons/favicon.ico">
        <meta name="msapplication-config" content="favicons/browserconfig.xml">
        <meta name="theme-color" content="#ffffff">
        
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        
        <link rel="stylesheet" href="css/aboutStyle.css">
        
        <title>Drive files - FeeltheTweet</title>
</head>
<body>
<!-- Uses a header that scrolls with the text, rather than staying
        locked at the top -->
        <div class="mdl-layout mdl-js-layout">
        <header class="mdl-layout__header mdl-layout__header--scroll">
        <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title">Google Drive</span>
        <!-- Add spacer, to align navigation to the right -->
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation -->
        <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="/EditFile.jsp">Create new file</a>
        <a class="mdl-navigation__link" href="/mydrivetoken.jsp">See drive token</a>
        </nav>
        </div>
        </header>
        <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">FeeltheTweet</span>
        <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="index.jsp">Home</a>
        <a class="mdl-navigation__link" href="/myTimeline">My timeline</a>
        <a class="mdl-navigation__link" href="/googleDriveListing">Google Drive files</a>
        <a class="mdl-navigation__link" href="functionality.jsp">Functionality</a>
        </nav>
        </div>
        <main class="mdl-layout__content">
        <div class="page-content">
            <div class="mdl-grid">
            <div class="mdl-cell mdl-cell--12-col">
             <h3>Files in your Drive</h3>
             </div>
                <div class="mdl-cell mdl-cell--12-col centered-w">
                <p class="message">${message}</p>
   <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp centered-c" id="files">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Name</th>
      <th class="mdl-data-table__cell--non-numeric">Size</th>
      <th class="mdl-data-table__cell--non-numeric">Last modification date</th>
      <th class="mdl-data-table__cell--non-numeric">Edit</th>
      <th class="mdl-data-table__cell--non-numeric">Delete</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${requestScope.files.items}" var="file">
    <tr>
      <td class="mdl-data-table__cell--non-numeric"><c:out value="${file.title}"/></td>
      <td class="mdl-data-table__cell--non-numeric"><c:out value="${file.fileSize}"/></td>
      <td class="mdl-data-table__cell--non-numeric"><c:out value="${file.modifiedDate}"/></td>
      <td class="mdl-data-table__cell--non-numeric"><button class="mdl-button"><a href="GoogleDriveFileUpdate?id=${file.id}""><i class="material-icons">create</i></a></button></td>
      <td class="mdl-data-table__cell--non-numeric"><button class="mdl-button"><a href="GoogleDriveFileDelete?id=${file.id}""><i class="material-icons">delete</i></a></button></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
                </div>
            </div>
        <footer class="mdl-mini-footer">
        <div class="mdl-mini-footer__left-section">
        <div class="mdl-logo">&copy; AISS 2016-2017</div>
        <ul class="mdl-mini-footer__link-list">
        <li><a href="/docs/index.html">API Documentation</a></li>
        <li><a href="/indexapi.jsp">Our API</a></li>
    
        <li><a href="about.html">About us</a></li>
        </ul>
        </div>
        </footer>
        </div>
        </main>
        </div>
</body>
</html>