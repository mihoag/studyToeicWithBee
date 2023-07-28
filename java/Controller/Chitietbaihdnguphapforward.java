package Controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.grammarguideline;
import DAO.DAOgrammarguideline;

/**
 * Servlet implementation class Chitietbaihdnguphapforward
 */
@WebServlet("/Chitietbaihdnguphapforward")
public class Chitietbaihdnguphapforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chitietbaihdnguphapforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("mabaihdnguphap");
		System.out.println(id);
		grammarguideline g = DAOgrammarguideline.selectById(Integer.parseInt(id));
	
		System.out.println(g.getGrammarguidelineid());
		System.out.println(g.getGrammarname());
		System.out.println(g.getContent());
		
		request.setAttribute("mabaihdnguphap",g.getGrammarguidelineid());
		request.setAttribute("grammarguidelinecontent", g.getContent());
		request.setAttribute("kitutrongdatabase","\n");
		request.setAttribute("kitutronghtml","<br/>");
		
		RequestDispatcher r = request.getRequestDispatcher("Chitietbaihdnguphap.jsp");
		
		r.forward(request, response);
	}

	
}
