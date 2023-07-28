package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOcmtgrammar;
import DB.MySQL;

/**
 * Servlet implementation class Xoabaihdnguphap
 */
@WebServlet("/Xoabaihdnguphap")
public class Xoabaihdnguphap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xoabaihdnguphap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("grammarguidelineid");
		DAOcmtgrammar.deleteByID(Integer.parseInt(id));
		
		String sql = "delete from grammarguideline where grammarguidelineid = ?";
		try {
			Connection con = MySQL.getConnection();
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, Integer.parseInt(id));
			int check = p.executeUpdate();
			if(check > 0)
			{
				System.out.println("Xoa thanh cong");
			}
			else
			{
				System.out.println("Xoa khong thanh cong");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher r = request.getRequestDispatcher("Listgrammarguidelinemanage?pageid=1");
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
