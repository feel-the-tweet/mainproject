package feelthetweet.api.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feelthetweet.api.model.Text;
import feelthetweet.model.resource.TextResource;

/**
 * Servlet implementation class DeleteTextServlet
 */
public class DeleteTextServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(DeleteTextServlet.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextResource tr = new TextResource();
		String id=request.getParameter("id");
		Collection<Text> texto = tr.getAllTexts();
		Collection<Text> textos = null;
		for (Text t:texto){
		if(t.getId().equals(id))
		{
			Boolean success = tr.deleteText(id);
			if(success==true)
			{
				textos = tr.getAllTexts();
				request.setAttribute("message", "Text deleted correctly");
				request.setAttribute("textos", textos);
				request.getRequestDispatcher("textsapi.jsp").forward(request,response);
			}}}
		if(textos==null)
		{
			log.warning("Invalid id!");
			request.setAttribute("message", "Invalid Id");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		//if(t.getId()!=id) 
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
