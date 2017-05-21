package feelthetweet.model.resources.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TrendsResources;
import twitter4j.conf.ConfigurationBuilder;

/* Pruebas automatizadas recursos Twitter MASHUP*/

public class TwitterTest {
	
	static ConfigurationBuilder cb = new ConfigurationBuilder();
	static TwitterFactory twitter;
	static Twitter tw;
	static Status status;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		cb.setDebugEnabled(true).setOAuthConsumerKey("JmOly0SsPxhcsj0FPjqU7ucLW")
		.setOAuthConsumerSecret("809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l")
		.setOAuthAccessToken("838794388750942209-Zrj5wNI9vaTOYsl8m4Kp7ma8YCYBXeR")
		.setOAuthAccessTokenSecret("BHJdWUjVbWMdyIxRvUXrMxpwXifk9yiXIEOjnMWgKZblY");
		
		twitter = new TwitterFactory(cb.build());
		tw = twitter.getInstance();
		
		status = tw.updateStatus("Prueba 2");
	}
	
	@Test
	public void testUpdateStatus() {
		try {
			Status status2 = tw.updateStatus("Prueba 2");
			
			assertNotNull("Status is null", status2);
			
			System.out.println("Successfully updated the status to [" + status2.getText() + "].");
			 
			tw.destroyStatus(status2.getId());
			System.out.println("Tweet created and deleted");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUserTimeline() {
	    List<Status> statuses;
		try {
			statuses = tw.getUserTimeline("@sergio_segura2");
			
			assertNotNull("Timeline is null", statuses);
			
			System.out.println("Showing user timeline.");
			for (Status statuss : statuses) {
		        System.out.println(statuss.getUser().getName() + ":" +
		                           statuss.getText());
		    }
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetHomeTimeline() {
	    List<Status> statuses;
		try {
			statuses = tw.getHomeTimeline();
			
			assertNotNull("Timeline is null", statuses);
			
			System.out.println("Showing home timeline.");
			for (Status statuss : statuses) {
		        System.out.println(statuss.getUser().getName() + ":" +
		                           statuss.getText());
		    }
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearch() {
		String queryaux = "Food";
		Query query = new Query(queryaux);
		
		List<Status> queryResult;
		try {
			System.out.println("Showing "+ queryaux +" search results");
			queryResult = tw.search(query).getTweets();
			
			assertNotNull("Collection of tweets is null", queryResult);
			
			System.out.println("Showing tweets.");
			for (Status status : queryResult) {
		        System.out.println(status.getUser().getName() + ":" +
		                           status.getText());
		    }
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTrends() {
		TrendsResources tr = tw.trends();
	    Trends t;
		try {
			//Esto es un localizador de 32bits que se llama WOEID - (Spain)
			t = tr.getPlaceTrends(23424950);
			String place = t.getLocation().getName();
			System.out.println("Showing the most popular trends in "+place);
			Trend[] ta = t.getTrends();
			Set<Trend> trends = new HashSet<>();
			
			assertNotNull("Collection of trending topics is null", ta);
			
			//Para mostrar solo top10 mas populares
			System.out.println("Showing trending topics.");
			int count = 0;
	        for (Trend trend : ta) {
	            if (count < 10) {
	                System.out.println(trend.getName());
	                
	                trends.add(trend);
	                count++;
	            }
	        }
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDestroyStatus() {
		try {
			Status destroyedStatus = tw.destroyStatus(status.getId());
			
			assertNotNull("Tweet to delete is null", destroyedStatus);
			
			System.out.println("Deleted tweet"+destroyedStatus);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
