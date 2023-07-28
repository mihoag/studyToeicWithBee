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
 * Servlet implementation class Insertgrammarguidelinename
 */
@WebServlet("/Insertgrammarguidelinename")
public class Insertgrammarguidelinename extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertgrammarguidelinename() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		String name = request.getParameter("grammarname");
		
		boolean check = DAOgrammarguideline.insertName(name);
		if(!check)
		{
			request.setAttribute("msglistgrammarguidelinemanage","Thêm không thành công");
			RequestDispatcher rd = request.getRequestDispatcher("Admin/Listgrammarguidelinemanage.jsp");
			rd.forward(request,response);
		}
		else
		{
			int grammarguidelineid = DAOgrammarguideline.getIDfromName(name);
			request.setAttribute("grammarguidelineid", grammarguidelineid);
			
			RequestDispatcher rd = request.getRequestDispatcher("Listgrammarguidelinemanage?pageid=1");
			rd.forward(request,response);
		}
		
		
		
	}

}
