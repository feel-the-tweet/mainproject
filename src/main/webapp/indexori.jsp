<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- Bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Favicons and mobile icons -->
    <link rel="apple-touch-icon" sizes="180x180" href="favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" href="favicons/favicon-32x32.png" sizes="32x32">
    <link rel="icon" type="image/png" href="favicons/favicon-16x16.png" sizes="16x16">
    <link rel="manifest" href="favicons/manifest.json">
    <link rel="mask-icon" href="favicons/safari-pinned-tab.svg">
    <link rel="shortcut icon" href="favicons/favicon.ico">
    <meta name="msapplication-config" content="favicons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">

    <!-- My Stylesheets -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Javascript for the menu -->
    <script src="includes/menu.js" type="text/javascript"></script>

    <title>Feel the Tweet</title>
</head>
<body onload="adjustMenu()">
    <div class="container-fluid">
       <div class="row content" id="row-content">
           <div class="col-sm-3 sidenav" id="menu">
               <h4>FeeltheTweet</h4>
               <ul class="nav nav-pills nav-stacked">
                   <li class="active"><a href="index.jsp">Home</a></li>
                   <li><a href="https://github.com/feel-the-tweet/mainproject.git">Repository</a></li>
               </ul>
           </div>

           <div class="col-sm-9" id="content">
               <img id="logo" src="img/FeeltheTweet_Logo.png" alt="App logo"/>
               <h3 class="text-center">AISS Mashup group 3-2</h3>
               <br>
               <p class="text-center">FeelTheTweet is a tool that with the aid of Big Data analyzes 
               Twitter users' feelings about a topic. For example, it is posible to have a general idea
               of what people think about a TV show, discussion or a commercial brand in the social network.
               </p>
               <br>
               
               <!-- Debug code
               <p>Document Size</p><p id="logg"></p>
               <p>Window Size</p><p id="logg1"></p>
               <p>footer Size</p><p id="logg2"></p>
               <p>Width Size</p><p id="logg3"></p> -->
           </div>
       </div>

   </div>
    <div id="footer">
        <p class="text-right"><a class="footer" href="about.jsp">About us</a></p>
    </div>
</body>
</html>