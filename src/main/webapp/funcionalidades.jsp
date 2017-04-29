<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Funcionalidades</title>
</head>
<body>
	<h3><a href="index.jsp">INDEX</a></h3>
	<h3><a href="myTimeline">View my Timeline</a></h3>
   	<h3><a href="trends">View popular Trends</a></h3>
    
<tag:notloggedin>
    <a href="signin"><img src="./img/Sign-in-with-Twitter-darker.png"/></a>
</tag:notloggedin>
<tag:loggedin>
    <h1>Welcome ${twitter.screenName} (${twitter.id})</h1>

    <form action="userTimeline" method="get">
        <textarea cols="80" rows="2" name="textusertl"></textarea>
        <input type="submit" name="viewusertl" value="Ver Timeline"/> Put a username like @etsii
    </form>
    
    <form action="analyzeTweetSentiment" method="get">
        <textarea cols="60" rows="4" name="tweetanalyze"></textarea>
        <input type="submit" name="viewtweetanalysis" value="Get Sentiment"/> Put a text shorter than 141 characters
    </form>
    
    <form action="analyzeTextSentiment" method="get">
        <textarea cols="80" rows="10" name="textanalyze"></textarea>
        <input type="submit" name="viewtextanalysis" value="Get Sentiment"/> Put a text longer than 141 characters
    </form>
    
    <form action="extractHashtagsUrl" method="get">
        <textarea cols="60" rows="2" name="urltoanalyze"></textarea>
        <input type="submit" name="viewextractedhashtags" value="Extract Hashtags"/> Put a URL like http://www.bbc.com/news/world-europe-39754909
    </form>
    
     <form action="twitterSearch" method="get">
        <textarea cols="50" rows="2" name="querytext"></textarea>
        <input type="submit" name="search" value="Search tweets"/> Searches tweets that contains the input
    </form>
    
    <a href="logout">logout</a>
    
   
</tag:loggedin>

	<a class="twitter-timeline" data-width="300" data-height="500" data-theme="dark" data-link-color="#19CF86" 
	href="https://twitter.com/FeelTheTweet_">Tweets by FeelTheTweet_</a> <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
	
</body>
</html>

