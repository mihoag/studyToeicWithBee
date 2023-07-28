package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.readexercise;
import DAO.DAOreadexercise;

/**
 * Servlet implementation class Hienthidsbtdoc
 */
@WebServlet("/Hienthidsbtdoc")
public class Hienthidsbtdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hienthidsbtdoc() {
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
		int count = 4;
		int pageid  = Integer.parseInt(pagestr);
		
		if(pageid  == 1)
		{
			
		}
		else
		{
			pageid = (pageid - 1)*count +1;
		}
		
		ArrayList<readexercise> arr = DAOreadexercise.selectFrom(pageid, count);
		for(int i = 0 ; i < arr.size() ; i++)
		{
			System.out.println(arr.get(i).getReadname());
		}
		
		int num = DAOreadexercise.countRow();
		int maxpageid;
		if(num % count == 0)
		{
			maxpageid = num/count;
		}
		else
		{
			maxpageid = num/count +1 ;
		}
		
		request.setAttribute("listarr", arr);
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("numberpage", Integer.parseInt(pagestr));
		
		
		RequestDispatcher r = request.getRequestDispatcher("Admin/Quanlylambtdoc.jsp");
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
