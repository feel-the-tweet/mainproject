package feelthetweet.controller.general;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.language.spi.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.language.v1.Document.Type;

/**
 * Servlet implementation class AnalyzeSentimentServlet
 */
public class AnalyzeSentimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyzeSentimentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
