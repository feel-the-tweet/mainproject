package feelthetweet.controller.general;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feelthetweet.model.google.drive.FileItem;
import feelthetweet.model.resource.GoogleDriveResource;

/**
 * Servlet implementation class NewSentimentFile
 */
public class NewSentimentFile extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSentimentFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken=(String)request.getSession().getAttribute("GoogleDrive-token");
		String title=request.getParameter("title");
		String content=request.getParameter("content");			
		if(accessToken!=null && !"".equals(accessToken)){
			if(title!=null && !"".equals(title)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				FileItem file = new FileItem();
				file.setTitle(title);
				file.setMimeType("text/plain");
				gdResource.insertFile(file, content);
				request.setAttribute("message", "A file with the sentiment has been added to your Drive!");
				request.getRequestDispatcher("/googleDriveListing").forward(request,response);
			}else{
				request.setAttribute("message", "Provide a name for the file");
				request.setAttribute("content", content);
				request.getRequestDispatcher("EditFile.jsp").forward(request,response);
			}
		}else{
			log.info("Trying to access to google drive without an acces token, redirecting to OAuth servlet");
			request.getRequestDispatcher("/AuthController/GoogleDrive").forward(request,response);
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
