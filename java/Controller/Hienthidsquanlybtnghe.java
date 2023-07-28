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

import BEAN.listenexercise;
import BEAN.listenquestion;
import DAO.DAOlistenexercise;
import DAO.DAOlistenquestion;

/**
 * Servlet implementation class Hienthidsquanlybtnghe
 */
@WebServlet("/Hienthidsquanlybtnghe")
public class Hienthidsquanlybtnghe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hienthidsquanlybtnghe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String pagestr = request.getParameter("pageid");
		int pageid = Integer.parseInt(pagestr);
		
		int count = 3;
		if(pageid == 1)
		{
			
		}
		else
		{
			pageid = (pageid - 1)*count  +1 ;
		}
		
		ArrayList<listenexercise> arr = DAOlistenexercise.selectFrom(pageid, count);
		request.setAttribute("list", arr);
		
		int maxpageid;
	    int num = DAOlistenexercise.countRow();
	    if(num % count == 0)
	    {
	    	maxpageid = num/count;
	    }
	    else
	    {
	       maxpageid = (num/count) + 1;
	    }
	    
	    request.setAttribute( "numberpage", Integer.parseInt(pagestr));
	    request.setAttribute("maxpageid", maxpageid);
	    
	    HttpSession r = request.getSession(true);
	    if(r.getAttribute("username") != null)
	    {
	    	System.out.println(r.getAttribute("username"));
	    	request.setAttribute("name",r.getAttribute("username"));
	    }
	    
	    RequestDispatcher re = request.getRequestDispatcher("Admin/Quanlylambtnghe.jsp");
	    re.forward(request, response);
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
