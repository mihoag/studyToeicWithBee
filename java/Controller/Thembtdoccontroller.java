package Controller;

import java.io.File;
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

import BEAN.readquestion;
import DAO.DAOreadquestion;

/**
 * Servlet implementation class Thembtdoccontroller
 */
@WebServlet("/Thembtdoccontroller")
public class Thembtdoccontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Thembtdoccontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String fileAddress = (String) request.getAttribute("fileAddress");
		System.out.println(fileAddress);
	    String id = (String) request.getAttribute("id");
	    FileInputStream fi;
	    try {
	    	fi = new FileInputStream(new File(fileAddress));
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(fi));
			Sheet s = wb.getSheetAt(0);
			for(int i = 1 ; i <= s.getLastRowNum() ; i++)
			{
				Row r = s.getRow(i);
			    int num = (int) r.getCell(0).getNumericCellValue(); 
			    String paragraph = r.getCell(1).getStringCellValue();
			    String question = r.getCell(2).getStringCellValue();
			    String ans1= r.getCell(3).getStringCellValue();
			    String ans2= r.getCell(4).getStringCellValue();
			    String ans3= r.getCell(5).getStringCellValue();
			    String ans4= r.getCell(6).getStringCellValue();
			    String correctans = r.getCell(7).getStringCellValue();
			    
			    DAOreadquestion.insertReadQues(new readquestion(0,num,paragraph,question,ans1,ans2,ans3,ans4,correctans, Integer.parseInt(id)));
			}
			 RequestDispatcher r = request.getRequestDispatcher("Hienthidsbtdoc?pageid=1");
			 r.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher r = request.getRequestDispatcher("Hienthidsbtdoc?pageid=1");
			r.forward(request, response);
			e.printStackTrace();
		}
	}
}
