package feelthetweet.api.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aylien.textapi.TextAPIException;

import feelthetweet.api.model.Text;
import feelthetweet.model.resource.TextResource;

/**
 * Servlet implementation class PostTextServlet
 */
public class PostTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextResource tr = new TextResource();
		//Collection<Text> texto = tr.getAllTexts();
		String textTitle=request.getParameter("title");
		String textContent=request.getParameter("content");
		Text texto = null;
		try {
			texto = tr.addText(new Text(textTitle,textContent));
		} catch (TextAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("texto", texto);
		request.getRequestDispatcher("idtextapi.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
