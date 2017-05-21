package feelthetweet.model.resources.test;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.HashTagsParams;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.HashTags;
import com.aylien.textapi.responses.Sentiment;

/* Pruebas automatizadas recursos Aylien MASHUP*/

public class AylienSentimentTest {
	
	static TextAPIClient client = new TextAPIClient("--", "--");
	static Sentiment sentiment;
	static String tweet,url; //text
	
	@BeforeClass
	public static void setUp() throws Exception {
		tweet = "I didn't like the hotel and the food was horrible";
		//text = "I didn't like the hotel and the food was horrible.I didn't like the hotel and the food was horrible.I didn't like the hotel and the food was horrible";
		url = "http://www.bbc.com/news/uk-39657382";
	}
	
	@Test
	public void testSentiment() {
		SentimentParams.Builder builder = SentimentParams.newBuilder();
		builder.setText(tweet);
		builder.setMode("tweet");
		//builder.setMode("document");
		try {
			sentiment = client.sentiment(builder.build());

			assertNotNull("Sentiment is null", sentiment);
			
			System.out.println(sentiment);
		} catch (TextAPIException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHashtags() {
		HashTagsParams.Builder builder = HashTagsParams.newBuilder();
		
		java.net.URL urlres;
		HashTags hashTags;
		Set<String> trends = new HashSet<>();
		try {
			urlres = new java.net.URL(url);
			builder.setUrl(urlres);
			
			hashTags = client.hashtags(builder.build());
			
			assertNotNull("Hashtag collection is null", hashTags.getHashtags());
			
			for (String hashTag: hashTags.getHashtags()) {
			    System.out.println(hashTag);
			    trends.add(hashTag);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TextAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
