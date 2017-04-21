package feelthetweet.controller.general;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feelthetweet.model.google.drive.FileItem;
import feelthetweet.model.resource.GoogleDriveResource;

public class DriveFileUpdate extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				FileItem file=gdResource.getFile(id);				
				req.setAttribute("file", file);
				req.setAttribute("content", gdResource.getFileContent(file));
				req.getRequestDispatcher("/EditFile.jsp").forward(req,resp);
			}else{
				log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for update!");
			req.getRequestDispatcher("/googleDriveListing").forward(req,resp);
		}
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			String content=req.getParameter("content");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				gdResource.updateFileContent(id, content);
				req.getRequestDispatcher("/googleDriveListing").forward(req,resp);
			}else{
				log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for update!");
			req.getRequestDispatcher("/googleDriveListing").forward(req,resp);
		}
	}
}
