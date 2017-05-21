package feelthetweet.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;

import feelthetweet.model.google.drive.FileItem;
import feelthetweet.model.resource.GoogleDriveResource;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class FeelthetweetTest {
	
	static TextAPIClient client = new TextAPIClient("e4c91a1c", "7af649d5a8502da656033172bf37ca7a");
	static Sentiment sentiment;
	static String tweet;
	static SentimentParams.Builder builder = SentimentParams.newBuilder();
	static ConfigurationBuilder cb = new ConfigurationBuilder();
	static TwitterFactory twitter;
	static Twitter tw;
	static Status status;
	static FileItem file1,file2;
	/* Se necesita un access token para poder autentificar las llamadas, para obtenerlo debe acceder a la lista de archivos
	 * y hacer click en "See drive token". Cópielo en la variable access_token.
	 */
	static String access_token = "ya29.Gl1RBENIn304KY4x9etAgtJuhQ9P4nDokQUhhWGX5UXaqJsG9b4l4Qb5mjB8vpm-Qlzy1NzG40aPrZyJM4JWjLpRJBKMTojUPZ-EVJqgJvyX951NTgiTH4PoGXYWHBk";
	static GoogleDriveResource gdr = new GoogleDriveResource(access_token);
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		cb.setDebugEnabled(true).setOAuthConsumerKey("JmOly0SsPxhcsj0FPjqU7ucLW")
		.setOAuthConsumerSecret("809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l")
		.setOAuthAccessToken("838794388750942209-Zrj5wNI9vaTOYsl8m4Kp7ma8YCYBXeR")
		.setOAuthAccessTokenSecret("BHJdWUjVbWMdyIxRvUXrMxpwXifk9yiXIEOjnMWgKZblY");
		
		twitter = new TwitterFactory(cb.build());
		tw = twitter.getInstance();
		
		file1 = new FileItem();
		file2 = new FileItem();
		
	}
	
	@Test
	public void testGetTweetSentiment(){
		List<Status> statuses;
		try{
			statuses = tw.getUserTimeline("@sergio_segura2");
			
			assertNotNull("Timeline is null", statuses);

			status = statuses.stream().findFirst().get();
			tweet = status.getText();
			System.out.println("Tweet: " +  tweet);
			
			builder.setText(tweet);
			builder.setMode("tweet");
			sentiment = client.sentiment(builder.build());
			assertNotNull("Sentiment is null", sentiment);
			System.out.println("Sentiment: " +  sentiment.toString());
			
		} catch (TwitterException | TextAPIException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveSentiment(){
		try{

			tweet = "Prueba sentimentSave";
			System.out.println("Tweet: " +  tweet);
			
			builder.setText(tweet);
			builder.setMode("tweet");
			sentiment = client.sentiment(builder.build());
			assertNotNull("Sentiment is null", sentiment);
			System.out.println("Sentiment: " +  sentiment.toString());
			
			file2.setTitle("Archivo prueba");
			String content = tweet+"\n"+sentiment.toString();
			
			String fileId = gdr.insertFile(file2, content);

			assertNotNull("Error when adding the file", fileId);
			assertEquals("The name of the files do not match", file2.getTitle(), gdr.getFile(fileId).getTitle());
			
			// Show result
			System.out.println("File id: " +  fileId);
			System.out.println("File name: " +  gdr.getFile(fileId).getTitle());
			if(fileId!=null){
				gdr.deleteFile(fileId);
				System.out.println("File succesfully created and deleted so tests don't spam");
			}
			
		} catch (TextAPIException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSaveTweetSentiment(){
	    List<Status> statuses;

		try {
			statuses = tw.getUserTimeline("@sergio_segura2");
			
			assertNotNull("Timeline is null", statuses);

			status = statuses.stream().findFirst().get();
			tweet = status.getText();
			System.out.println("Tweet: " +  tweet);
			
			builder.setText(tweet);
			builder.setMode("tweet");
			sentiment = client.sentiment(builder.build());
			assertNotNull("Sentiment is null", sentiment);
			System.out.println("Sentiment: " +  sentiment.toString());
			
			file1.setTitle("Archivo prueba");
			String content = tweet+"\n"+sentiment.toString();
			
			String fileId = gdr.insertFile(file1, content);

			assertNotNull("Error when adding the file", fileId);
			assertEquals("The name of the files do not match", file1.getTitle(), gdr.getFile(fileId).getTitle());
			
			// Show result
			System.out.println("File id: " +  fileId);
			System.out.println("File name: " +  gdr.getFile(fileId).getTitle());
			if(fileId!=null){
				gdr.deleteFile(fileId);
				System.out.println("File succesfully created and deleted so tests don't spam");
			}
			
		} catch (TwitterException | TextAPIException e) {
			e.printStackTrace();
		}
	}
}
