<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Sign in with Twitter example</title>
</head>
<body>
<tag:notloggedin>
    <a href="signin"><img src="./img/Sign-in-with-Twitter-darker.png"/></a>
</tag:notloggedin>
<tag:loggedin>
    <h1>Welcome ${twitter.screenName} (${twitter.id})</h1>
	<a href="home.jsp">HOME</a>
    <form action="/post" method="post">
        <textarea cols="80" rows="2" name="text"></textarea>
        <input type="submit" name="post" value="update"/>
    </form>
    <a href="/googleDriveListing">Listado de ficheros de Google Drive</a>
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

