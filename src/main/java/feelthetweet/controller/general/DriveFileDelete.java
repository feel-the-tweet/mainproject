package feelthetweet.controller.general;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feelthetweet.model.resource.GoogleDriveResource;


public class DriveFileDelete extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				gdResource.deleteFile(id);
				log.info("File with id '"+id+"' deleted!");
				req.getRequestDispatcher("/googleDriveListing").forward(req,resp);
			}else{
				log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for delete!");
			req.getRequestDispatcher("/googleDriveListing").forward(req,resp);
		}
	}
}
