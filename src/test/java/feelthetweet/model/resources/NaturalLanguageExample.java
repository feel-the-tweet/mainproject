package feelthetweet.model.resources;

import java.io.IOException;

import com.google.cloud.language.spi.v1.LanguageServiceClient;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.Sentiment;

public class NaturalLanguageExample {

	public static void main(String[] args) {
		
		// Instantiates a client
	    LanguageServiceClient language = null;
		try {
			language = LanguageServiceClient.create();
			// The text to analyze
		    String text = "Hello, world!";
		    Document doc = Document.newBuilder()
		            .setContent(text).setType(Type.PLAIN_TEXT).build();

		    // Detects the sentiment of the text
		    Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

		    System.out.printf("Text: %s%n", text);
		    System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
