package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import BEAN.listenquestion;
import DAO.DAOlistenquestion;

/**
 * Servlet implementation class Lambtnghe
 */
@WebServlet("/Lambtnghe")
public class Lambtnghe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lambtnghe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String listenexerciseid = request.getParameter("listenexerciseid");
		String pagestr = request.getParameter("pageid");
		int pageid = Integer.parseInt(pagestr);
		int count = 1;
		if(pageid == 1)
		{
			
		}
		else
		{
			pageid = (pageid-1)*count + 1;
		}
		
		ArrayList<listenquestion> arr = DAOlistenquestion.selectFromByID(Integer.parseInt(listenexerciseid), pageid, count);
		request.setAttribute("list", arr);
		request.setAttribute("maxpageid", DAOlistenquestion.countRow(Integer.parseInt(listenexerciseid)));
		request.setAttribute("numberpage", Integer.parseInt(pagestr));
		request.setAttribute("listenexerciseid", listenexerciseid);
		request.setAttribute("listenquestionid", arr.get(0).getListenquestionid());
		ServletContext context= request.getServletContext();
		String fileaddress = context.getRealPath("FileAudioImageListening")  + File.separator + arr.get(0).getImagename(); 
		System.out.println(fileaddress);
	    request.setAttribute("fileaddress", fileaddress);
		
		RequestDispatcher r = request.getRequestDispatcher("Lambtnghe.jsp");
		r.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	     String kq = request.getParameter("kq");
	     String listenquestionid=  request.getParameter("listenquestionid");
	     String listenexerciseid = request.getParameter("listenexerciseid");
	     
	     if(kq.equals(""))
	     {
	    	 request.setAttribute("msglambtphandoc","Yêu cầu trả lời hết các câu hỏi");
			 RequestDispatcher r = request.getRequestDispatcher("Thongbaoloibtdoc.jsp");
			 r.forward(request, response);
	     }
	     else
	     {
	    	 //System.out.println(listenquestionid);
	    	// System.out.println(listenexerciseid);
	    	 request.setAttribute("kq", kq);
	    	// System.out.println(kq);
	    	 ArrayList<listenquestion> arr = DAOlistenquestion.selectFromByID(Integer.parseInt(listenquestionid), Integer.parseInt(listenexerciseid));
	    	 System.out.println(arr.get(0).getCorrectanswer());
	    	 request.setAttribute("dapandungbtnghe",arr);
	    	 
	    	 RequestDispatcher r = request.getRequestDispatcher("Ketquabtnghe.jsp");
	    	r.forward(request, response);
	     }
	     
		
	}

}
