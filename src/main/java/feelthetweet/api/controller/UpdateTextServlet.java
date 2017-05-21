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
 * Servlet implementation class UpdateTextServlet
 */
public class UpdateTextServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(UpdateTextServlet.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextResource tr = new TextResource();
		String id=request.getParameter("id");
		String textTitle=request.getParameter("title");
		String textContent=request.getParameter("content");
		Collection<Text> textos = tr.getAllTexts();
		Text texto = null;
		for (Text t:textos){
		if(t.getId().equals(id))
		{
			t.setTitle(textTitle);
			t.setContent(textContent);
			Boolean success = tr.updateText(t);
			if(success==true)
			{
				texto = tr.getText(id);
				request.setAttribute("message", "Text updated correctly");
				request.setAttribute("texto", texto);
				request.getRequestDispatcher("idtextapi.jsp").forward(request,response);
			}}}
		if(texto==null)
		{
			log.warning("Invalid id!");
			request.setAttribute("message", "Invalid Id");
			request.getRequestDispatcher("error.jsp").forward(request,response);
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
