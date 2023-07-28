package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.cmtvocabulary;
import BEAN.member;
import DAO.DAOcmtvocabulary;

/**
 * Servlet implementation class CmtVocabularycontroller
 */
@WebServlet("/CmtVocabularycontroller")
public class CmtVocabularycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CmtVocabularycontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String cmtvocabularycontent =  request.getParameter("cmtvocabularycontent");
		String memberid=  request.getParameter("memberid");
        String vocabularyguidelineid = request.getParameter("vocabularyguidelineid");
        
        //System.out.println(memberid);
        //System.out.println(vocabularyguidelineid);
        
        DAOcmtvocabulary.insertcmtvocabulary(new cmtvocabulary(0,cmtvocabularycontent,Integer.parseInt(memberid), Integer.parseInt(vocabularyguidelineid),""));
        
        ArrayList<cmtvocabulary> arr = DAOcmtvocabulary.selectAll();
		request.setAttribute("list", arr);
		request.setAttribute("countrow", DAOcmtvocabulary.countRow());
		
		RequestDispatcher r = request.getRequestDispatcher("listcmtVocabulary.jsp");
		r.forward(request, response);
		
		
	}

}
