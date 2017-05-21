<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

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
        
        <title>Functionality - FeeltheTweet</title>
</head>
<body>
<!-- Uses a header that scrolls with the text, rather than staying
        locked at the top -->
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <header class="mdl-layout__header mdl-layout__header--scroll">
        <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title">Functionalities</span>
        <!-- Add spacer, to align navigation to the right -->
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation -->
        <nav class="mdl-navigation">
        
        <a class="mdl-navigation__link" href="/logout">Log out</a>
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
                <div class="mdl-cell mdl-cell--12-col"><h3>Explore other functionalities...</h3></div>
                <div class="mdl-cell mdl-cell--4-col centered-w">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp centered-c">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Search user's tweets</h2>
  </div>
<form action="userTimeline" method="get">
  <div class="mdl-card__supporting-text">
    <!-- Simple Textfield -->
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" id="searchUser" name="textusertl">
    <label class="mdl-textfield__label" for="searchUser">Type the user ej: @etsii</label>
  </div>
  </div>
  <div class="mdl-card__actions mdl-card--border">
      <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit" name="viewusertl" value="Start stalking!"/>
  </div>
</form>
  <!--<div class="mdl-card__menu">
    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>-->
</div>

                </div>
                <div class="mdl-cell mdl-cell--4-col centered-w">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp centered-c">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Search tweets that contains...</h2>
  </div>
<form action="twitterSearch" method="get">
  <div class="mdl-card__supporting-text">
    <!-- Simple Textfield -->
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" id="searchTweets" name="querytext">
    <label class="mdl-textfield__label" for="searchTweets">Try something like 'Ed Sheeran'</label>
  </div>
  </div>
  <div class="mdl-card__actions mdl-card--border">
      <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit" name="search" value="Search"/>
  </div>
</form>
  <!--<div class="mdl-card__menu">
    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>-->
</div>

                </div>
                <div class="mdl-cell mdl-cell--4-col centered-w">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp centered-c">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Extract hashtags from large document</h2>
  </div>
<form action="extractHashtagsUrl" method="get">
  <div class="mdl-card__supporting-text">
    <!-- Simple Textfield -->
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" id="documenturl" name="urltoanalyze">
    <label class="mdl-textfield__label" for="documenturl">URL where the document/article/review is</label>
  </div>
  </div>
  <div class="mdl-card__actions mdl-card--border">
    <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit" name="viewusertl" value="Tag it!"/>
  </div>
</form>
  <!--<div class="mdl-card__menu">
    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>-->
</div>

                 </div>
                <div class="mdl-cell mdl-cell--12-col"><br/></div>
                <div class="mdl-cell mdl-cell--6-col centered-w">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp centered-c">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Analyze short text sentiment</h2>
  </div>
<form action="analyzeTweetSentiment" method="get">
  <div class="mdl-card__supporting-text">
    <!-- Simple Textfield -->
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" id="tweet" name="tweetanalyze">
    <label class="mdl-textfield__label" for="tweet">Short text, less than 140 characters.</label>
  </div>
  </div>
  <div class="mdl-card__actions mdl-card--border">
      <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit" name="viewtweetanalysis" value="Analyze"/>
  </div>
</form>
  <!--<div class="mdl-card__menu">
    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>-->
</div>

                </div>
                <div class="mdl-cell mdl-cell--6-col centered-w">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp centered-c">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Analyze sentiment</h2>
  </div>
<form action="analyzeTextSentiment" method="get">
  <div class="mdl-card__supporting-text">
    <!-- Simple Textfield -->
  <div class="mdl-textfield mdl-js-textfield">
      <textarea class="mdl-textfield__input" id="document" type="text" rows= "3" name="textanalyze"></textarea>
    <label class="mdl-textfield__label" for="document">Long text, like an article or review.</label>
  </div>
  </div>
  <div class="mdl-card__actions mdl-card--border">
      <input class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit" name="viewtextanalysis" value="Analyze"/>
  </div>
</form>
  <!--<div class="mdl-card__menu">
    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>-->
</div>

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