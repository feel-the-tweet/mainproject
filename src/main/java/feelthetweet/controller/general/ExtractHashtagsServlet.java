package feelthetweet.controller.general;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.HashTagsParams;
import com.aylien.textapi.responses.HashTags;

/**
 * Servlet implementation class ExtractHashtagsServlet
 */
public class ExtractHashtagsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtractHashtagsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TextAPIClient client = new TextAPIClient("e4c91a1c", "7af649d5a8502da656033172bf37ca7a");
		HashTagsParams.Builder builder = HashTagsParams.newBuilder();
		
		String urltoanalyze = request.getParameter("urltoanalyze");
		java.net.URL url = new java.net.URL(urltoanalyze);
		builder.setUrl(url);
		
		HashTags hashTags;
		Set<String> trends = new HashSet<>();
		try {
			hashTags = client.hashtags(builder.build());

			for (String hashTag: hashTags.getHashtags()) {
			    System.out.println(hashTag);
			    trends.add(hashTag);
			}
			
			request.setAttribute("trends", trends);
			request.getRequestDispatcher("/extractedhashtags.jsp").forward(request,response);
		} catch (TextAPIException e) {
			// TODO Auto-generated catch block
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
