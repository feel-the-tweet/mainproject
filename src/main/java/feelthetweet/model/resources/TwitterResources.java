package feelthetweet.model.resources;

import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpResponseEvent;
import twitter4j.HttpResponseListener;
import twitter4j.OEmbed;
import twitter4j.OEmbedRequest;
import twitter4j.ResponseList;
import feelthetweet.model.Status;
//import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterBase;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


public class TwitterResources{

	private String urirest= "https://api.twitter.com/1.1/";
	
	public TwitterResources(){
	}
	
	public Twitter getConfiguration(String consumerKey,String consumerSecret){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		//TOKENs Puestos por nosotros
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		//Obtenidos del login
		.setOAuthAccessToken("838794388750942209-dV0qn5hdllQ6jmUfKf12YHSzWY3ACQt")
		.setOAuthAccessTokenSecret("sxYq9C24QyT3OKKSgMNJvNaUmWhA5n71hlt7Pi2t85Vy2");
		
		TwitterFactory twitter = new TwitterFactory(cb.build());
		Twitter tw = twitter.getInstance();
		
		return tw;
	}
	
	public String getStatus(long statusId){
		
		ClientResource cr = null;
		Status status = null;
		try{
			cr = new ClientResource(urirest+"statuses/show/"+statusId+".json");
			status = cr.get(Status.class);
		}catch(ResourceException e){
			System.err.println("Error when retrieving the tweet: " + cr.getResponse().getStatus());
		}
		return status.getText();
    }

  public Status updateStatus(String status){
	  ClientResource cr = null;
	  Status status2 = null;
	  try{
		  cr = new ClientResource(urirest+"statuses/update.json");
		  cr.setEntityBuffering(true);
		  status2 = cr.post(status, Status.class);
	  }catch(ResourceException e){
			System.err.println("Error when posting the tweet: " + cr.getResponse().getStatus());
	  }
	  return status2;
  }
  
//    public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
//        return factory.createStatusList(get(urirest + "statuses/retweets/" + statusId
//                + ".json?count=100"));
//    }
//    
    
//
//    public IDs getRetweeterIds(long statusId, int count, long cursor) throws TwitterException {
//        return factory.createIDs(get(conf.getRestBaseURL() + "statuses/retweeters/ids.json?id=" + statusId
//                + "&cursor=" + cursor + "&count=" + count));
//    }

//    public Status destroyStatus(long statusId) throws TwitterException {
//        return factory.createStatus(post(conf.getRestBaseURL() + "statuses/destroy/" + statusId + ".json"));
//    }
//
//
//
//
//    public Status retweetStatus(long statusId) throws TwitterException {
//        return factory.createStatus(post(conf.getRestBaseURL() + "statuses/retweet/" + statusId + ".json"));
//    }
//
//
//    public OEmbed getOEmbed(OEmbedRequest req) throws TwitterException {
//        return factory.createOEmbed(get(conf.getRestBaseURL()
//                + "statuses/oembed.json", req.asHttpParameterArray()));
//    }

}
