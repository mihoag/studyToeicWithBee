package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.member;
import DAO.DAOmember;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
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
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		member m = new member(username,password,1,name);
		
		if(DAOmember.isExist(m))
		{
			request.setAttribute("msg", "Tài khoản đã tồn tại");
			RequestDispatcher r = request.getRequestDispatcher("SignUp.jsp");
			r.forward(request, response);
		}
		else if(DAOmember.insert(m))
		{
			// tạo session định danh người dùng
			request.setAttribute("msg", "Bạn đã đăng kí thành công. Đăng nhập lại!");
			RequestDispatcher r = request.getRequestDispatcher("Login.jsp");
			r.forward(request, response);
		}
		else
		{
			response.sendError(404);
		}
	}

}
