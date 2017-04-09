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
		
		twitter.setOAuthConsumer("JmOly0SsPxhcsj0FPjqU7ucLW","809X1X90UTyhoCvV6GTe0ZlYsYjGRVtKjxvIW4nvDxPUI5p56l");
		twitter.setOAuthAccessToken(new AccessToken("838794388750942209-dV0qn5hdllQ6jmUfKf12YHSzWY3ACQt","sxYq9C24QyT3OKKSgMNJvNaUmWhA5n71hlt7Pi2t85Vy2"));
		
		try{
			ResponseList<Status> a = twitter.getUserTimeline(new Paging(1,5));
			for (Status b:a){
				System.out.println(b.getText());
			}
		}catch(Exception e){
			
		}

	}

}
