<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Twitter js -->
    <script src="js/twitter4MDL.js"type="text/javascript"></script>

    <!-- Material Design -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

    <!-- Favicons y miniaturas para Movil -->
    <link rel="apple-touch-icon" sizes="180x180" href="favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" href="favicons/favicon-32x32.png" sizes="32x32">
    <link rel="icon" type="image/png" href="favicons/favicon-16x16.png" sizes="16x16">
    <link rel="manifest" href="favicons/manifest.json">
    <link rel="mask-icon" href="favicons/safari-pinned-tab.svg" color="#5b7dd5">
    <link rel="shortcut icon" href="favicons/favicon.ico">
    <meta name="msapplication-config" content="favicons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <tag:notloggedin>
    <!-- My custom stylesheet -->
    <link rel="stylesheet" href="css/custommdlvideo.css">
    </tag:notloggedin>

    <tag:loggedin>
        <!-- My custom stylesheet -->
        <link rel="stylesheet" href="css/custommdl.css">
    </tag:loggedin>

    <title>FeeltheTweet</title>
</head>
<body>
<tag:notloggedin>
    <div class="background-wrap">
    <video id="video-bg-elem" preload="auto" autoplay="true" loop="loop" muted="muted">
    <source src="media/backgroundvid.mp4" type="video/mp4">
    Video not supported
    </video>
    </div>

    <!-- Always shows a header, even in smaller screens. -->
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <main class="mdl-layout__content">
    <div class="page-content"><div class="mdl-grid">
    <!--<div class="mdl-cell mdl-cell--12-col"><img src="img/FTTBirds.png" class="logo"></div>-->
    </div>
    <div class="page-content">
    <div class="mdl-grid">
    <div class="mdl-cell mdl-cell--4-col trends"><div class="mycontent"><p>Here goes the trends<p></p></div></div>
    <div class="mdl-cell mdl-cell--4-col"><div class="mycontent"><img src="img/FTTBirds.png" class="logo"><button onclick="location.href='signin';" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
    <i class="material-icons">perm_identity</i> Sign in with Twitter
    </button></div></div>
    <div class="mdl-cell mdl-cell--4-col"><div class="mycontent"><a class="twitter-timeline" data-width="300" data-height="500" data-theme="dark" data-link-color="#19CF86"
    href="https://twitter.com/FeelTheTweet_">Tweets by FeelTheTweet_</a></div></div>
    </div>
    <footer class="mdl-mini-footer">
    <div class="mdl-mini-footer__left-section">
    <div class="mdl-logo">&copy; AISS 2016-2017</div>
    <ul class="mdl-mini-footer__link-list">
    <li><a href="/docs/index.html">API Documentation</a></li>
    <li><a href="help.html">Help</a></li>
    <li><a href="about.html">About us</a></li>
    </ul>
    </div>
    </footer>
    </div>
    </div>
    </main>
    </div>

</tag:notloggedin>
<tag:loggedin>
    <!-- Always shows a header, even in smaller screens. -->
    <div class="demo-layout-transparent mdl-layout mdl-js-layout">
    <header class="mdl-layout__header mdl-layout__header--transparent">
    <div class="mdl-layout__header-row">
    <!-- Title -->
    <span class="mdl-layout-title">FeeltheTweet</span>
    <!-- Add spacer, to align navigation to the right -->
    <div class="mdl-layout-spacer"></div>
    <!-- Navigation. We hide it in small screens. -->
    <nav class="mdl-navigation mdl-layout--large-screen-only">
    <a class="logout" href="/logout">Log out</a>
    </nav>
    </div>
    </header>
    <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">FeeltheTweet</span>
    <nav class="mdl-navigation">
    <a class="mdl-navigation__link" href="/myTimeline">My timeline</a>
    <a class="mdl-navigation__link" href="/googleDriveListing">My Drive files</a>
    <a class="mdl-navigation__link" href="functionality.jsp">Functionality</a>
    </nav>
    </div>
    <main class="mdl-layout__content">
    <div class="page-content"><div class="mdl-grid">
    <h2>Welcome, ${twitter.screenName}</h2>
    </div>
    <div class="page-content">
    <div class="mdl-grid">
    <div class="mdl-cell mdl-cell--4-col trends"><div class="mycontent"><p>Here goes the trends<p></p></div></div>
    <div class="mdl-cell mdl-cell--4-col"><div class="mycontent"><form action="/post" method="post">
    <div class="mdl-textfield mdl-js-textfield tweetsend">
    <textarea class="mdl-textfield__input" id="sample5" type="text" rows= "3" name="text"></textarea>
    <label class="mdl-textfield__label" for="sample5">What's happening?</label>
    </div>
    <input type="submit" name="post" value="Send tweet" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
    </input>
    </form></div></div>
    <div class="mdl-cell mdl-cell--4-col"><div class="mycontent"><a class="twitter-timeline" data-width="300" data-height="500" data-theme="dark" data-link-color="#19CF86"
    href="https://twitter.com/FeelTheTweet_">Tweets by FeelTheTweet_</a></div></div>
    </div>
    <footer class="mdl-mini-footer">
    <div class="mdl-mini-footer__left-section">
    <div class="mdl-logo">&copy; AISS 2016-2017</div>
    <ul class="mdl-mini-footer__link-list">
    <li><a href="/docs/index.html">API Documentation</a></li>
    <li><a href="help.html">Help</a></li>
    <li><a href="about.html">About us</a></li>
    </ul>
    </div>
    </footer>

    </div>
    </div>
    </main>
    </div>
    </div>
</tag:loggedin>
</body>
</html>

