package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.grammarguideline;
import DAO.DAOgrammarguideline;

/**
 * Servlet implementation class Dsbaihdnguphapforward
 */
@WebServlet("/Dsbaihdnguphapforward")
public class Dsbaihdnguphapforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dsbaihdnguphapforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
String pageidstr = request.getParameter("pageid");
		
		
		int pageid = Integer.parseInt(pageidstr);
		int count = 2;
		
		
		if (pageid == 1)
		{
			
		}
		else 
		{
			pageid = pageid -1;
			pageid = pageid * count +1;
		}
		
		
	     ArrayList<grammarguideline> list = DAOgrammarguideline.selectFrom(pageid, count);
		
		
		int sumrow = DAOgrammarguideline.countRow();
		
		int maxpageid= 0;
		
		if ((sumrow/count)%2==0)
		{
			maxpageid = (sumrow/count);
		}
		else
		{
			maxpageid = (sumrow/count)+1;
		}
		
		request.setAttribute("maxpageid",maxpageid);
		
		request.setAttribute("listgrammarguideline",list);
		
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		//System.out.println(request.getAttribute("name"));
		HttpSession r = request.getSession(true);
	    if(r.getAttribute("username") != null)
	    {
	    	System.out.println(r.getAttribute("username"));
	    	request.setAttribute("name",r.getAttribute("name"));
	    }
		
		RequestDispatcher rd = request.getRequestDispatcher("Dsbaihdnguphap.jsp");
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
