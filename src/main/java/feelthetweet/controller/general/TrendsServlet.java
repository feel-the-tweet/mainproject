package feelthetweet.controller.general;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.api.TrendsResources;

/**
 * Servlet implementation class TrendsServlet
 */
public class TrendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
	    TrendsResources tr = twitter.trends();
	    Trends t;
		try {
			//Esto es un localizador de 32bits que se llama WOEID - (Spain)
			t = tr.getPlaceTrends(23424950);
			String place = t.getLocation().getName();
			System.out.println("Showing the most popular trends in "+place);
			Trend[] ta = t.getTrends();
			Set<Trend> trends = new HashSet<>();
//			for (int i = 0; i< ta.length;i++) {
//		    	System.out.println(ta[i].getName());
//		    }
			//Para mostrar solo top10 mas populares
			int count = 0;
	        for (Trend trend : ta) {
	            if (count < 10) {
	                System.out.println(trend.getName());
	                
	                trends.add(trend);
	                count++;
	            }
	        }
	        request.setAttribute("place", place);
	        request.setAttribute("trends", trends);
	        request.getRequestDispatcher("/trends.jsp").forward(request,response);
		} catch (TwitterException e) {
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
