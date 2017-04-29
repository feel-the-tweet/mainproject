package feelthetweet.api.model;

import java.util.Date;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;

public class Text {

	private String id;
	private String title;
	private String content;
	String sentiment;
	private String createdAt;
	private TextAPIClient client = new TextAPIClient("e4c91a1c", "7af649d5a8502da656033172bf37ca7a");
	
	public Text() {
		this.createdAt = new Date().toString();
	}

	public Text(String title, String content) throws TextAPIException {
		this.title = title;
		this.content = content;
		this.sentiment = getSentiment();
		this.createdAt = new Date().toString();
	}
	
	public Text(String id, String title, String content) throws TextAPIException {
		this.id=id;
		this.title = title;
		this.content = content;
		this.sentiment = getSentiment();
		this.createdAt = new Date().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSentiment() throws TextAPIException {
		
		SentimentParams.Builder builder = SentimentParams.newBuilder();
		builder.setText(getContent());
		
		if(getContent().length()<=140){
			builder.setMode("tweet");
		}else{
			builder.setMode("document");
		}
		
		String res = client.sentiment(builder.build()).toString();
		
		return res;
	}

	public void setSentiment() throws TextAPIException {
		this.sentiment = getSentiment();
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
