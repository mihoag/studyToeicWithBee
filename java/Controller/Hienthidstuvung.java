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

import BEAN.vocabularyguideline;
import DAO.DAOvocabularyguideline;

/**
 * Servlet implementation class Hienthidshdtuvung
 */
@WebServlet("/Hienthidstuvung")
public class Hienthidstuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hienthidstuvung() {
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
			pageid = (pageid-1)*count + 1;
		}
		
		int maxpageid;
		int num = DAOvocabularyguideline.countRow();
		
		
		if(num % count == 0)
		{
			maxpageid = num / count;
		}
		else
		{
		   maxpageid = num / count  +1;	
		}
		ArrayList<vocabularyguideline> arr = DAOvocabularyguideline.selectFrom(pageid, count);
		
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("numberpage", Integer.parseInt(pagestr));
		request.setAttribute("list", arr);
		
		HttpSession r = request.getSession(true);
	    if(r.getAttribute("username") != null)
	    {
	    	System.out.println(r.getAttribute("username"));
	    	request.setAttribute("name",r.getAttribute("username"));
	    }
		
		RequestDispatcher re = request.getRequestDispatcher("Admin/Dsbaihdtuvung.jsp");
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
