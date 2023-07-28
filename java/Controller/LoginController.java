package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DAO.DAOmember;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(username + " " + pass);
		if(!DAOmember.isExist1(username, pass))
		{
			request.setAttribute("msg", "Tài khoản không tồn tại");
			RequestDispatcher r = request.getRequestDispatcher("Login.jsp");
			r.forward(request, response);
		}
		else
		{
		// tao phien session
		if(DAOmember.getID(username, pass) == 1)
		{
			HttpSession r = request.getSession(true);
			r.setAttribute("username", username);
			
			r.setAttribute("id", DAOmember.getMemberID(username));
			r.setAttribute("name", DAOmember.getName(username));
			request.setAttribute("name", DAOmember.getName(username));
       
			RequestDispatcher req = request.getRequestDispatcher("homefoward");
			req.forward(request, response);
			
		}
		else if(DAOmember.getID(username, pass) == 2)
		{
			HttpSession r = request.getSession(true);
			r.setAttribute("username", username);
			r.setAttribute("id", DAOmember.getMemberID(username));
			r.setAttribute("name", DAOmember.getName(username));
			
			request.setAttribute("name", username);
		
			RequestDispatcher req = request.getRequestDispatcher("Admin/Home.jsp");
			req.forward(request, response);
		}
	}
	}

}
