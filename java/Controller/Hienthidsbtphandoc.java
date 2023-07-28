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
import BEAN.readexercise;
import DAO.DAOlistenexercise;
import DAO.DAOreadexercise;

/**
 * Servlet implementation class Hienthidsbtphandoc
 */
@WebServlet("/Hienthidsbtphandoc")
public class Hienthidsbtphandoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hienthidsbtphandoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String pagestr = request.getParameter("pageid");
		int pageid = Integer.parseInt(pagestr);
	    int count = 4;
	    if(pageid == 1)
	    {
	    	
	    }
	    else
	    {
	    	pageid = (pageid-1)*count + 1;
	    }
	    
	    ArrayList<readexercise> arr = DAOreadexercise.selectFrom(pageid, count);
	    
	    int maxpageid;
	    int num = DAOreadexercise.countRow();
	    
	    if(num % count == 0)
	    {
	    	maxpageid = num/count;
	    }
	    else
	    {
	    	maxpageid = num/count + 1;
	    }
	    request.setAttribute("maxpageid", maxpageid);
	    request.setAttribute("list", arr);
	    request.setAttribute("pageid", Integer.parseInt(pagestr));
	    
	    HttpSession r = request.getSession(true);
	    if(r.getAttribute("username") != null)
	    {
	    	//System.out.println(r.getAttribute("username"));
	    	request.setAttribute("name",r.getAttribute("name"));
	    }
	    
	    RequestDispatcher re = request.getRequestDispatcher("listBTdoc.jsp");
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
