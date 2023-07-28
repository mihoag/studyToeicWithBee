package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOgrammarguideline;

/**
 * Servlet implementation class Grammarguidelinecontentcontroller
 */
@WebServlet("/Grammarguidelinecontentcontroller")
public class Grammarguidelinecontentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grammarguidelinecontentcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
	
		String grammarguidelineid = request.getParameter("grammarguidelineid");
		String content = request.getParameter("content");
		DAOgrammarguideline.updateContent(Integer.parseInt(grammarguidelineid), content);
		RequestDispatcher r = request.getRequestDispatcher("Listgrammarguidelinemanage?pageid=1");	
		r.forward(request, response);
	}

}
