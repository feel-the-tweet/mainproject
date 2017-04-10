package aiss.model.resources;

import org.junit.Test;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TimelineResourceTest {

	public static void main(String[] args) {
		Twitter twitter=new TwitterFactory().getInstance();
		
		twitter.setOAuthConsumer("","");
		twitter.setOAuthAccessToken(new AccessToken("",""));
		
		try{
			ResponseList<Status> a = twitter.getUserTimeline(new Paging(1,5));
			for (Status b:a){
				System.out.println(b.getText());
			}
		}catch(Exception e){
			
		}

	}

}
