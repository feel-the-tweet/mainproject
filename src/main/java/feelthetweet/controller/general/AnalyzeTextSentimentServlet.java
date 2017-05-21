package feelthetweet.controller.general;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;

/**
 * Servlet implementation class AnalyzeTextSentimentServlet
 */
public class AnalyzeTextSentimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyzeTextSentimentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TextAPIClient client = new TextAPIClient("e4c91a1c", "7af649d5a8502da656033172bf37ca7a");
		SentimentParams.Builder builder = SentimentParams.newBuilder();
		String text = request.getParameter("textanalyze");
		builder.setText(text);
		builder.setMode("document");
		Sentiment sentiment;

		try {
			
			sentiment = client.sentiment(builder.build());
			String content = text+"\n"+sentiment.toString();
			System.out.println(sentiment);
			request.setAttribute("sentiment", sentiment);
			request.setAttribute("content", content);
			request.getRequestDispatcher("/sentimentresult.jsp").forward(request,response);
			
		} catch (TextAPIException e) {
			
			e.printStackTrace();
			request.setAttribute("message", "Error");
			request.getRequestDispatcher("/error.jsp").forward(request,response);
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
