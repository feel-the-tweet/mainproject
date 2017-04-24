package feelthetweet.model.resources;


import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;


public class AylienSentimentExample {

	public static void main(String[] args) {
		
		TextAPIClient client = new TextAPIClient("e4c91a1c", "7af649d5a8502da656033172bf37ca7a");
		SentimentParams.Builder builder = SentimentParams.newBuilder();
		builder.setText("Agustín saca buenas notas");
		builder.setMode("tweet");
		Sentiment sentiment;
		
		try {
			
			sentiment = client.sentiment(builder.build());
			System.out.println(sentiment);
			
		} catch (TextAPIException e) {
			
			e.printStackTrace();
		}
	
	}

}
