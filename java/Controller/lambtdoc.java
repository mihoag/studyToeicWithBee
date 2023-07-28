package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.readquestion;
import DAO.DAOreadquestion;

/**
 * Servlet implementation class lambtdoc
 */
@WebServlet("/lambtdoc")
public class lambtdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lambtdoc() {
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
		String readexerciseid = request.getParameter("readexerciseid");
		
		System.out.println(pagestr);
		System.out.println(readexerciseid);
		
		int pageid = Integer.parseInt(pagestr);
		int count = 1;
		if(pageid == 1)
		{
			
		}
		else
		{
			pageid = (pageid-1)*count + 1;
		}
		ArrayList<readquestion> arr = DAOreadquestion.selectFromByID(Integer.parseInt(readexerciseid), pageid, count);
		request.setAttribute("list", arr);
		
		int num = DAOreadquestion.countRow(Integer.parseInt(readexerciseid));
		int maxpageid = num / count;
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("readexerciseid", Integer.parseInt(readexerciseid));
		request.setAttribute("numberpage", Integer.parseInt(pagestr));
		
		RequestDispatcher r = request.getRequestDispatcher("Lambtphandoc.jsp");
		r.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    ///	doGet(request, response);
		String kq = request.getParameter("kq");
		String num = request.getParameter("num");
		String readexerciseid = request.getParameter("readexerciseid");
		
		if(kq.equals(""))
		{
			request.setAttribute("msglambtphandoc","Yêu cầu trả lời hết các câu hỏi");
			RequestDispatcher r = request.getRequestDispatcher("Thongbaoloibtdoc.jsp");
			r.forward(request, response);
		}
		else
		{
			request.setAttribute("kq", kq);
			request.setAttribute("dapandungbtdoc", DAOreadquestion.selectByNumandID(Integer.parseInt(num), Integer.parseInt(readexerciseid)));
			
			RequestDispatcher r= request.getRequestDispatcher("Ketquabtdoc.jsp");
			r.forward(request, response);
		}
	}

}
