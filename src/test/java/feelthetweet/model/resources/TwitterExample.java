package feelthetweet.model.resources;

import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.api.TrendsResources;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterExample {
	
	/*
	 * Para que esto funcione teneis que poner las claves e importar las clases que vayais a usar 
	 * (del paquete twitter4j). Para que haya funcionado en Maven se ha añadido dos dependencias
	 * nuevas. 
	 */

	public static void main(String[] args) {
		//La autenticacion
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("JmOly0SsPxhcsj0FPjqU7ucLW")
		.setOAuthConsumerSecret("809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l")
		.setOAuthAccessToken("838794388750942209-Zrj5wNI9vaTOYsl8m4Kp7ma8YCYBXeR")
		.setOAuthAccessTokenSecret("BHJdWUjVbWMdyIxRvUXrMxpwXifk9yiXIEOjnMWgKZblY");
	
		//Para escribir un tweet
		
		TwitterFactory twitter = new TwitterFactory(cb.build());
		Twitter tw = twitter.getInstance();
	    
//	    Status status;
//		try {
//			status = tw.updateStatus("Prueba 2");
//			 System.out.println("Successfully updated the status to [" + status.getText() + "].");
//		} catch (TwitterException e) {
//			e.printStackTrace();
//		}
	   
	    
		
	    //Para consultar la timeline de un usuario en especial
		
	    List<Status> statuses;
		try {
			statuses = tw.getUserTimeline("@LuisRus10");
			for (Status statuss : statuses) {
		        System.out.println(statuss.getUser().getName() + ":" +
		                           statuss.getText());
		    }
			System.out.println("Showing home timeline.");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	    
	    
		
		//Para consultar trending topics
		
	    TrendsResources tr = tw.trends();
	    Trends t;
		try {
			//Esto es un localizador de 32bits que se llama WOEID - (Spain)
			t = tr.getPlaceTrends(23424950);
			
			Trend[] ta = t.getTrends();
//			for (int i = 0; i< ta.length;i++) {
//		    	System.out.println(ta[i].getName());
//		    }
			//Para mostrar solo top10 mas populares
			int count = 0;
	        for (Trend trend : ta) {
	            if (count < 10) {
	                System.out.println(trend.getName());
	                count++;
	            }
	        }
		} catch (TwitterException e) {
			e.printStackTrace();
		} 

		//Para Streaming
//	    TwitterStream ts = new TwitterStreamFactory(cb.build()).getInstance();
//	    
//	    StatusListener listener = new StatusListener(){
//	        public void onStatus(Status status) {
//	            System.out.println(status.getUser().getName() + " : " + status.getText());
//	        	System.out.println(status.getCreatedAt());
//	        }
//	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
//	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
//	        public void onException(Exception ex) {
//	            ex.printStackTrace();
//	        }
//			@Override
//			public void onScrubGeo(long arg0, long arg1) {
//				// TODO Auto-generated method stub
//				
//			}
//			@Override
//			public void onStallWarning(StallWarning arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//	    };
//	    
//	    FilterQuery fq = new FilterQuery();
//	    String keywords[] = {"#ThorRagnarok"};
//	    fq.track(keywords);
//	    
//	    ts.addListener(listener);
//	    ts.filter(fq);
					
	}

}
