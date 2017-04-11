package feelthetweet.model.resources;

import org.junit.Test;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import feelthetweet.model.resources.TwitterResources;

public class TimelineResourceTest {

	public static void main(String[] args) {
		TwitterResources tr = new TwitterResources();
		Twitter idk=tr.getConfiguration("JmOly0SsPxhcsj0FPjqU7ucLW","809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l");
//		twitter.setOAuthConsumer("","");
//		twitter.setOAuthAccessToken(new AccessToken("",""));

		try{
			
			long id = 851103899264090119L;
			idk.showStatus(id);
//			tr.updateStatus("Probando");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
