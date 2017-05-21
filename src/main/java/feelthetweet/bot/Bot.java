package feelthetweet.bot;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feelthetweet.bot.aylien.SentimentTool;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Bot extends HttpServlet{

	private static final Logger log = Logger.getLogger(Bot.class.getName());
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String ip = req.getRemoteAddr();
		if (ip.equals("0.1.0.1")) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("--")
			  .setOAuthConsumerSecret("--")
			  .setOAuthAccessToken("---")
			  .setOAuthAccessTokenSecret("--");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			
			String tweet = "Sentiment Analysis:\n";
			
			try {
			Trends trends = twitter.getPlaceTrends(1);
			int numOfTrends = 0;
			for (int i = 0; i < trends.getTrends().length; i++) {
				String trend = trends.getTrends()[i].getName();
				
				if (tweet.length() + trend.length() + 5 < 140 && numOfTrends < 4) {
					String sentiment = SentimentTool.extractSentiment(trends.getTrends()[i].getName());
					if (sentiment!="") {
					tweet += trend + " - " + sentiment + "\n";
					numOfTrends++;
					}
				} else {
					break;
				}
				    System.out.println(trend);
			}
			
			twitter.updateStatus(tweet);
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		} else {
			log.info("Unknown IP is trying to access the bot: " + ip);
		}
		resp.setStatus(200);
			
	}
}
