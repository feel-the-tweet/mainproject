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

    <!-- Twitter's Follow-Button Javascript -->
    <script src="http://platform.twitter.com/widgets.js" type="text/javascript"></script>

    <!-- My Stylesheets -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Javascript for the menu -->
    <script src="menu.js" type="text/javascript"></script>

    <title>About us</title>
</head>
<body onload="adjustMenu()">

<div class="container-fluid">
    <div class="row content" id="row-content">
        <div class="col-sm-3 sidenav" id="menu">
            <h4>FeeltheTweet</h4>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="https://github.com/feel-the-tweet/mainproject.git">Repository</a></li>
            </ul>
        </div>

        <div class="col-sm-9" id="content">
            <h2>Our team <small>class group 3-2</small></h2>
            <br>
            
            <h4>Francisco de Paz Galán</h4>
            <a href="mailto:frandepaz@yahoo.es" class="btn btn-success btn-sm">
            <span class="glyphicon glyphicon-envelope"></span> frandepaz@yahoo.es
            </a>
            <a class="twitter-follow-button" href="https://twitter.com/franidePaki"
               data-show-count="false" data-size="large">Follow @franidePaki</a>
            
            <h4>Agustín Núñez Arenas</h4>
            <a href="mailto:seviagus@gmail.com" class="btn btn-success btn-sm">
            <span class="glyphicon glyphicon-envelope"></span> seviagus@gmail.com</a>
            <a class="twitter-follow-button" href="https://twitter.com/Agusnez"
               data-show-count="false" data-size="large">Follow @Agusnez</a>
            
            <h4>Luis Rus Pegalajar</h4>
            <a href="mailto:lrp_ruspeg@hotmail.com" class="btn btn-success btn-sm">
            <span class="glyphicon glyphicon-envelope"></span> Lrp_ruspeg@hotmail.com</a>
            <a class="twitter-follow-button" href="https://twitter.com/LuisRus10"
               data-show-count="false" data-size="large">Follow @LuisRus10</a>
            
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