package Controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import BEAN.examinationquestion;

import DAO.DAOexaminationquestion;


/**
 * Servlet implementation class ThemDeThicontroller
 */
@WebServlet("/ThemDeThicontroller")
public class ThemDeThicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDeThicontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*FileInputStream fi;
		   try {
			fi = new FileInputStream("F:\\HK2_Nam2\\WEBJSPSERVLET\\insertExcel\\src\\main\\webapp\\file\\user.xls");
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(fi));
			
		    Sheet s = wb.getSheetAt(0);
		    for(int i = 1 ; i <= s.getLastRowNum(); i++)
		    {
		    	Row r = s.getRow(i);
		    	int stt = (int) r.getCell(0).getNumericCellValue();
		    	String name = r.getCell(1).getStringCellValue();
		    	String pass = r.getCell(2).getStringCellValue();
		    	
		    	account ac = new account(stt,name,pass);
		    	DAOaccount.insertData(ac);
		    }
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("mess", e.getMessage());
			e.printStackTrace();
		}
		 
		   RequestDispatcher r = request.getRequestDispatcher("result.jsp");
		   r.forward(request, response);
		
		*/
		
		String id = (String) request.getAttribute("id");
		//System.out.println(id);
		DAOexaminationquestion.deleteExQ(Integer.parseInt(id));
		
		String addressName = (String) request.getAttribute("fileAddress");
		FileInputStream fi;
		try {
			fi = new FileInputStream(addressName);
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(fi));
			
			Sheet s = wb.getSheetAt(0);
			for(int i = 1 ; i <= s.getLastRowNum() ; i++)
			{
				Row r = s.getRow(i);
				
				int num = (int) r.getCell(0).getNumericCellValue();
				String imagequestion = r.getCell(1).getStringCellValue();
				String audiogg = r.getCell(2).getStringCellValue();
				String audiomp3 = r.getCell(3).getStringCellValue();
				String paragraph = r.getCell(4).getStringCellValue();
				String question = r.getCell(5).getStringCellValue();
				String option1 = r.getCell(6).getStringCellValue();
				String option2 = r.getCell(7).getStringCellValue();
				String option3 = r.getCell(8).getStringCellValue();
				String option4 = r.getCell(9).getStringCellValue();
				String correctanswer = r.getCell(10).getStringCellValue();
				
				DAOexaminationquestion.insertExQ(new examinationquestion(0,num,imagequestion,audiogg,audiomp3
						,paragraph, question, option1, option2, option3, option4, correctanswer, Integer.parseInt(id)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		RequestDispatcher r  =request.getRequestDispatcher("Hienthidsquanlydethi?pageid=1");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POst");
		String id = (String) request.getAttribute("id");
		request.setAttribute("id", id);
		doGet(request, response);
	}

}
