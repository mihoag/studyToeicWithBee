package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.cmtgrammar;
import DAO.DAOcmtgrammar;

/**
 * Servlet implementation class Cmtgrammarcontroller
 */
@WebServlet("/Cmtgrammarcontroller")
public class Cmtgrammarcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cmtgrammarcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String cmtgrammarcontent  =request.getParameter("cmtgrammarcontent");
		String memberid = request.getParameter("memberid");
		String grammarguidelineid = request.getParameter("grammarguidelineid");
		
		
		
		DAOcmtgrammar.insertGrammar(new cmtgrammar(cmtgrammarcontent, Integer.parseInt(memberid), Integer.parseInt(grammarguidelineid),""));
		
		ArrayList<cmtgrammar> arr = DAOcmtgrammar.selectbyID(Integer.parseInt(grammarguidelineid));
		request.setAttribute("listcommentgrammar", arr);
		request.setAttribute("countrow", DAOcmtgrammar.countRow());
		
		RequestDispatcher r = request.getRequestDispatcher("Listcmtgrammarguide.jsp");
		r.forward(request, response);	
	}

}
