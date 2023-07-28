package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.vocabularycontent;
import DAO.DAOcmtvocabulary;
import DAO.DAOvocabularycontent;
import DAO.DAOvocabularyguideline;

/**
 * Servlet implementation class Chitiethdtuvungforward
 */
@WebServlet("/Chitiethdtuvungforward")
public class Chitiethdtuvungforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chitiethdtuvungforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	// 	response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		
		String vocabularyguidelineid  = request.getParameter("vocabularyguidelineid");
		ArrayList<vocabularycontent> arr = DAOvocabularycontent.selectByID(Integer.parseInt(vocabularyguidelineid));
        
		
		request.setAttribute("list", arr);
		request.setAttribute("nameVocab", DAOvocabularyguideline.getName(Integer.parseInt(vocabularyguidelineid)));
		request.setAttribute("vocabularyguidelineid", vocabularyguidelineid);
		request.setAttribute("countrow", DAOcmtvocabulary.countRow());
		
		RequestDispatcher r = request.getRequestDispatcher("ChitietbaihdVocab.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
