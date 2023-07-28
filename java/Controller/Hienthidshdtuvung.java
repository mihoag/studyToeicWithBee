package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.grammarguideline;
import BEAN.vocabularyguideline;
import DAO.DAOgrammarguideline;
import DAO.DAOvocabularyguideline;
import DB.MySQL;

/**
 * Servlet implementation class Hienthidshdtuvung
 */
@WebServlet("/Hienthidshdtuvung")
public class Hienthidshdtuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hienthidshdtuvung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try 
		{
			String pageidstr = request.getParameter("pageid");
			
			
			int pageid = Integer.parseInt(pageidstr);
			int count = 4;
			
			
			if (pageid == 1)
			{
				
			}
			else 
			{
				pageid = pageid -1;
				pageid = pageid * count +1;
			}
			
			
			Connection conn = MySQL.getConnection();
			
			ArrayList<vocabularyguideline> list = DAOvocabularyguideline.selectFrom(pageid, count);
			
			
			int sumrow = DAOvocabularyguideline.countRow();
			
			int maxpageid= 0;
			
			if (sumrow % count ==0)
			{
				maxpageid = (sumrow/count);
			}
			else
			{
				maxpageid = (sumrow/count)+1;
			}
			
			request.setAttribute("maxpageid",maxpageid);
			
			request.setAttribute("list",list);
			
			request.setAttribute("pageid",Integer.parseInt(pageidstr));
			
			conn.close();
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msglistgrammarguidelinemanage",e.getMessage());
		}
		

	    HttpSession r = request.getSession(true);
	    if(r.getAttribute("username") != null)
	    {
	    	//System.out.println(r.getAttribute("username"));
	    	request.setAttribute("name",r.getAttribute("name"));
	    }
		RequestDispatcher rd = request.getRequestDispatcher("ListVocabulary.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
