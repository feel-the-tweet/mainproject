package feelthetweet.model.aylien;

import java.util.ArrayList;
import java.util.List;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.LanguageParams;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Language;
import com.aylien.textapi.responses.Sentiment;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Sentiments {

	private static int NUM_OF_TWEETS = 100; //Will be multiple of 15, because tweets are added in groups of 15
	
	public Sentiments() {
		
	}
	
	public static String extractSentiment(String hashtag) {
		//Aylien
		TextAPIClient client = new TextAPIClient("e4c91a1c", "7af649d5a8502da656033172bf37ca7a");
		
		int positive = 0;
		int negative = 0;
		int neutral = 0;
		
		//Twitter
		List<Status> tweets = searchTweets(hashtag);
		int num = 0;
		
		SentimentParams.Builder builderS = SentimentParams.newBuilder();
		LanguageParams.Builder builderL = LanguageParams.newBuilder();
		
		for (Status s : tweets) {
			builderL.setText(s.getText());
			try {
				Language language = client.language(builderL.build());

				if (language.getLanguage().equals("en")) {
					builderS.setText(s.getText());
					builderS.setMode("tweet");
					Sentiment sentiment = client.sentiment(builderS.build());
					if (sentiment.getPolarity().equals("positive")) {
						positive++;
					} else if (sentiment.getPolarity().equals("negative")) {
						negative++;
					} else {
						neutral++;
					}
					num++;
				}
			} catch (TextAPIException e) {
				e.printStackTrace();
				break;
			}

		}

		System.out.println("Positive: " + positive);
		System.out.println("Neutral: " + neutral);
		System.out.println("Negative: " + negative);
		System.out.println("Num of tweets analysed: " + num);

		if (positive > negative && positive > neutral) {
			return "🙂";
		} else if (negative > positive && negative > neutral) {
			return "☹️";
		} else {
			return "😐";
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
		
		ArrayList<Status> tweets = new ArrayList<Status>();
	    while (tweets.size () < NUM_OF_TWEETS) {
			try {
				QueryResult result = twitter.search(query);
				tweets.addAll(result.getTweets());
			} catch (TwitterException e) {
				e.printStackTrace();
				break;
			}
	    }
	    return tweets;
	}
	
	
}
