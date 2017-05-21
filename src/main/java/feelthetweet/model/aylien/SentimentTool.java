package feelthetweet.model.aylien;

import java.util.ArrayList;
import java.util.List;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SentimentTool {
	
	public SentimentTool() {
		
	}
	
	public static String extractSentiment(String hashtag) {
		
		TextAPIClient client = new TextAPIClient("dd20314c", "a95ea8247bda1952d9921914a75e483f");
		
		int positive = 0;
		int negative = 0;
		int neutral = 0;
		int unknown = 0;
	
		List<Status> tweets = searchTweets(hashtag);
		if (tweets.size() > 5) {
			int num = 0;

			SentimentParams.Builder builderS = SentimentParams.newBuilder();
			System.out.println("Analyzing...");
			for (Status s : tweets) {
				try {
					if (s.getLang().equals("en")) {
						builderS.setText(s.getText());
						builderS.setMode("tweet");
						
						Sentiment sentiment = client.sentiment(builderS.build());
						System.out.println(s.getText()+ "  //  " + sentiment.getPolarity());
						if (sentiment.getPolarity().equals("positive") && sentiment.getPolarityConfidence() > 0.5) {
							positive++;
						} else if (sentiment.getPolarity().equals("negative")
								&& sentiment.getPolarityConfidence() > 0.5) {
							negative++;
						} else if (sentiment.getPolarity().equals("neutral")
								&& sentiment.getPolarityConfidence() > 0.5) {
							neutral++;
						} else {
							unknown++;
						}
						num++;
					}
				} catch (TextAPIException e) {
					if (e.getMessage().contains("hits")) {
						System.out.println("You exceeded the maximum API calls!");
					} else {
						e.printStackTrace();
					}

					break;
				}

			}

			System.out.println("Positive: " + positive);
			System.out.println("Neutral: " + neutral);
			System.out.println("Negative: " + negative);
			System.out.println("Unknown: " + unknown);
			System.out.println("Num of tweets analysed: " + num);

			if (positive > negative) {
				return "🙂";
			} else if (negative > positive) {
				return "☹️";
			} else {
				return "😐";
			}
		} else {
			return "";
		}
	}
	
	public static List<Status> searchTweets(String hashtag) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("JmOly0SsPxhcsj0FPjqU7ucLW")
		  .setOAuthConsumerSecret("809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l")
		  .setOAuthAccessToken("838794388750942209-Zrj5wNI9vaTOYsl8m4Kp7ma8YCYBXeR")
		  .setOAuthAccessTokenSecret("BHJdWUjVbWMdyIxRvUXrMxpwXifk9yiXIEOjnMWgKZblY");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		Query query = new Query(hashtag);
		query.setResultType(Query.POPULAR);
		
		System.out.println("Searching tweets of " + hashtag);
		
		ArrayList<Status> tweets = new ArrayList<Status>();
		try {
				QueryResult result = twitter.search(query.lang("en"));
				List<Status> collectedTweets = result.getTweets();
				System.out.println("Adding " + collectedTweets.size() + " tweets");
				tweets.addAll(collectedTweets);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
	    System.out.println(tweets.size() + " tweets collected!");
	    return tweets;
	}
	
	
}
