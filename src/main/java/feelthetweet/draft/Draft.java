package feelthetweet.draft;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feelthetweet.controller.general.StatusDelete;
import feelthetweet.model.aylien.Sentiments;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TrendsResources;
import twitter4j.conf.ConfigurationBuilder;

public class Draft extends HttpServlet{

	private static final Logger log = Logger.getLogger(Draft.class.getName());
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String ip = req.getRemoteAddr();
		if (ip.equals("0.1.0.1")) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("JmOly0SsPxhcsj0FPjqU7ucLW")
			  .setOAuthConsumerSecret("809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l")
			  .setOAuthAccessToken("838794388750942209-Zrj5wNI9vaTOYsl8m4Kp7ma8YCYBXeR")
			  .setOAuthAccessTokenSecret("BHJdWUjVbWMdyIxRvUXrMxpwXifk9yiXIEOjnMWgKZblY");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			
			String tweet = "Analysis:\n";
			
			try {
			Trends trends = twitter.getPlaceTrends(1);
			for (int i = 0; i < trends.getTrends().length; i++) {
				if (tweet.length() + trends.getTrends()[i].getName().length() + 5 < 140) {
					tweet += trends.getTrends()[i].getName() + " - " + Sentiments.extractSentiment(trends.getTrends()[i].getName()) + "\n";
				} else {
					break;
				}
				    System.out.println(trends.getTrends()[i].getName());
			}
			
			twitter.updateStatus(tweet);
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		} else if(ip.equals("127.0.0.1")) {
			System.out.println("Let's see what we've found...");
			System.out.println(Sentiments.extractSentiment("#Loveislove"));
		
		} else {
			log.info("Unknown IP is trying to access the bot: " + ip);
		}
		resp.setStatus(200);
			
	}
}
