package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.examination;
import DAO.DAOexamination;

/**
 * Servlet implementation class Hienthidsquanlydethi
 */
@WebServlet("/Hienthidsquanlydethi")
public class Hienthidsquanlydethi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hienthidsquanlydethi() {
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
		int count = 3;
		int pageid = Integer.parseInt(pagestr);
		if(pageid == 1)
		{
			
		}
		else
		{
			pageid = (pageid - 1) * count + 1;
		}
		
		ArrayList<examination> arr = DAOexamination.selectFrom(pageid, count);
		int num = DAOexamination.countRow();
		int maxpageid = 0;
		if(num%count == 0)
		{
			maxpageid = num/count;
		}
		else
		{
			maxpageid = num/count + 1;
		}
		
		request.setAttribute("list", arr);
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("pageid", Integer.parseInt(pagestr));
		
		RequestDispatcher r = request.getRequestDispatcher("Admin/Quanlydethi.jsp");
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
