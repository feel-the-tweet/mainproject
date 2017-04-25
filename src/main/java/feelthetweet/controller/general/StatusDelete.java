package feelthetweet.controller.general;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Servlet implementation class StatusDelete
 */
public class StatusDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StatusDelete.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
		
		if(id!=null && !"".equals(id)){
			try {
				twitter.destroyStatus(Long.parseLong(id));
				log.info("Tweet with id '"+id+"' deleted!");
				request.setAttribute("message", "Tweet with id '"+id+"' succesfully deleted!");
				request.getRequestDispatcher("/myTimeline").forward(request,response);
				
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			log.warning("Invalid id for delete!");
			request.getRequestDispatcher("index.jsp").forward(request,response);
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
