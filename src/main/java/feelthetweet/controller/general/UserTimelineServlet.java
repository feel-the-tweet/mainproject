package feelthetweet.controller.general;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Servlet implementation class UserTimelineServlet
 */
public class UserTimelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTimelineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
		String user = request.getParameter("textusertl");
		
	    List<Status> timeline;
		try {
			System.out.println("Showing "+ user +" timeline.");
			timeline = twitter.getUserTimeline(user);
			for (Status status : timeline) {
		        System.out.println(status.getUser().getName() + ":" +
		                           status.getText());
		    }
			request.setAttribute("timeline", timeline);
			request.setAttribute("usertl", user);
			request.getRequestDispatcher("/timeline.jsp").forward(request,response);
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
