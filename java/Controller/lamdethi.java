package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.answeruser;
import BEAN.examinationquestion;
import BEAN.result;
import DAO.DAOexaminationquestion;
import DAO.DAOresult;

/**
 * Servlet implementation class lamdethi
 */
@WebServlet("/lamdethi")
public class lamdethi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lamdethi() {
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
		if(s.getAttribute("id") != null)
		{
			String examinationid = request.getParameter("examinationid");
			int memberid = (int) s.getAttribute("id");
			
		    ArrayList<examinationquestion> arr = DAOexaminationquestion.selectByID(Integer.parseInt(examinationid));
		    request.setAttribute("memberid", memberid);
		    request.setAttribute("examinationid", examinationid);
		    request.setAttribute("list", arr);
		    request.setAttribute("kitutrongdatabase","\n");
			request.setAttribute("kitutronghtml","<br/>");
			
			RequestDispatcher r = request.getRequestDispatcher("Lambaithitoeic.jsp");
			r.forward(request, response);
			
		}
		else
		{
			request.setAttribute("msg", "Bạn cần đăng nhập trước khi làm đề thi");
			RequestDispatcher r = request.getRequestDispatcher("Login.jsp");
			r.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        String examinationid = request.getParameter("examinationid");
        String memberid = request.getParameter("memberid");
        System.out.println(examinationid);
        
         int countrow  = DAOexaminationquestion.countRowbyID(Integer.parseInt(examinationid));
         ArrayList<examinationquestion> arr = DAOexaminationquestion.selectByID(Integer.parseInt(examinationid));
         request.setAttribute("listcorrectanswer", arr);
         System.out.println("Countrow : " + countrow);
         int socaudung = 0;
         ArrayList<answeruser> listans = new ArrayList<answeruser>();
         for(int i = 1; i <= countrow ; i++)
         {
        	String ans = request.getParameter("ans[" +i +"]");
        	if(ans != null)
        	{
        	System.out.println(ans);
        	listans.add(new answeruser(i,ans));
        	if(ans.equals(arr.get(i-1).getCorrectanswer()))
        	{
        		socaudung++;
        	}
        	}
         }
         request.setAttribute("memberid", memberid);
         request.setAttribute("listansweruser", listans);
         int socausai = countrow - socaudung;
         
      //  System.out.println(socaudung);
        // System.out.println(socausai);
         Date d = new Date();
         result r = new result(0,socaudung,socausai,d.toString(),Integer.parseInt(examinationid), Integer.parseInt(memberid));
         DAOresult.insertresult(r);
         ArrayList<result> listResult = new ArrayList<result>();
         listResult.add(r);
         
         request.setAttribute("ketquathi", listResult);
         
         
         RequestDispatcher re = request.getRequestDispatcher("Ketquathi.jsp");
         re.forward(request, response);
	}

}
