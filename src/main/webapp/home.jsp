<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Home</title>
</head>
<body>
	<a href="index.jsp">INDEX</a>
<tag:notloggedin>
    <a href="signin"><img src="./img/Sign-in-with-Twitter-darker.png"/></a>
</tag:notloggedin>
<tag:loggedin>
    <h1>Welcome ${twitter.screenName} (${twitter.id})</h1>

    <form action="userTimeline" method="get">
        <textarea cols="80" rows="2" name="textusertl"></textarea>
        <input type="submit" name="viewusertl" value="viewtl"/>
    </form>
    <a href="myTimeline">View my Timeline</a>
    <a href="trends">View popular Trends</a>
    
    <form action="analyzeTweetSentiment" method="get">
        <textarea cols="60" rows="4" name="tweetanalyze"></textarea>
        <input type="submit" name="viewtweetanalysis" value="viewtweetanalysis"/>
    </form>
    
    <form action="analyzeTextSentiment" method="get">
        <textarea cols="80" rows="10" name="textanalyze"></textarea>
        <input type="submit" name="viewtextanalysis" value="viewtextanalysis"/>
    </form>
    
    <form action="extractHashtagsUrl" method="get">
        <textarea cols="60" rows="2" name="urltoanalyze"></textarea>
        <input type="submit" name="viewextractedhashtags" value="viewextractedhashtags"/>
    </form>
    
    <a href="logout">logout</a>
</tag:loggedin>

	<a class="twitter-timeline" data-width="300" data-height="500" data-theme="dark" data-link-color="#19CF86" 
	href="https://twitter.com/FeelTheTweet_">Tweets by FeelTheTweet_</a> <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
	
</body>
</html>

