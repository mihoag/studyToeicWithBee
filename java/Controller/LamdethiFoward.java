package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.examination;
import DAO.DAOexamination;

/**
 * Servlet implementation class LamdethiFoward
 */
@WebServlet("/LamdethiFoward")
public class LamdethiFoward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LamdethiFoward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession s = request.getSession(true);
		if(s.getAttribute("id") == null)
		{
			request.setAttribute("msg", "Bạn cần đăng nhập để làm đề thi");
			RequestDispatcher r = request.getRequestDispatcher("Login.jsp");
			r.forward(request, response);
		}
		else
		{
		String pagestr = request.getParameter("pageid");
	    int count = 3; 
	    int pageID = Integer.parseInt(pagestr);
	    if(pageID == 1)
	    {
	         	
	    }
	    else
	    {
	    	pageID = (pageID - 1)*count + 1;
	    }
	    
	    int numRow = DAOexamination.countRow();
	    int maxpageid;
	    if(numRow %  count == 0)
	    {
	    	maxpageid = numRow / count;
	    }
	    else
	    {
	        maxpageid = (numRow / count) + 1;	
	    }
	    
	    ArrayList<examination>  arr = DAOexamination.selectFrom(pageID, count);
	    
	    System.out.println(pagestr);
	    request.setAttribute("pageid", Integer.parseInt(pagestr));
	    request.setAttribute("maxpageid", maxpageid);
	    System.out.println(maxpageid);
	    request.setAttribute("list", arr);
	   
	    HttpSession r = request.getSession(true);
	    if(r.getAttribute("username") != null)
	    {
	    	//System.out.println(r.getAttribute("username"));
	    	request.setAttribute("name",r.getAttribute("name"));
	    }
	    
	    RequestDispatcher re = request.getRequestDispatcher("ListExamination.jsp");
	    re.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
