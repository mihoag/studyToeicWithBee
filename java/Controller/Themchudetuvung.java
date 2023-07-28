package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.vocabularyguideline;
import DAO.DAOvocabularyguideline;

/**
 * Servlet implementation class Themchudetuvung
 */
@WebServlet("/Themchudetuvung")
public class Themchudetuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themchudetuvung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String image = "anh1.png";
		String vocabularyname = request.getParameter("vocabularyname");
		
	    DAOvocabularyguideline.insertvocabularyguideline(new vocabularyguideline(0,vocabularyname,image,0));
	    
	    RequestDispatcher r = request.getRequestDispatcher("Hienthidstuvung?pageid=1");
	    r.forward(request, response);
	}

}
