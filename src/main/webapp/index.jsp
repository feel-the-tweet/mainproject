<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Index</title>
</head>
<body>
<tag:notloggedin>
    <a href="signin"><img src="./img/Sign-in-with-Twitter-darker.png"/></a>
</tag:notloggedin>
<tag:loggedin>
    <h1>Welcome ${twitter.screenName} (${twitter.id})</h1>
	<h2><a href="funcionalidades.jsp">FUNCIONALIDADES</a></h2>
	
	<h2>Post a tweet</h2>
    <form action="/post" method="post">
        <textarea cols="80" rows="2" name="text"></textarea>
        <input type="submit" name="post" value="Post"/>
    </form>

    <h3><a href="/googleDriveListing">See your files</a></h3>
    
    <h3><a href="/myTimeline">See your timeline</a></h3>
    
    <h3><a href="about.jsp">About us</a></h3>
    
    <h3><a href="docs/index.html">Feelthetweet API Documentation</a></h3>
    
    <a href="/logout">logout</a>
</tag:loggedin>

	<a class="twitter-timeline" data-width="300" data-height="500" data-theme="dark" data-link-color="#19CF86" 
	href="https://twitter.com/FeelTheTweet_">Tweets by FeelTheTweet_</a> <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
	
	<h2> Tokens de OAuth </h2>
    <table>
    	<tr><th>Google Drive:<th><td><c:out value='${sessionScope["GoogleDrive-token"]}' />
    </table>
</body>
</html>

