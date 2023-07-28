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

import BEAN.listenquestion;
import DAO.DAOlistenquestion;

/**
 * Servlet implementation class Thembtnghecontroller
 */
@WebServlet("/Thembtnghecontroller")
public class Thembtnghecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Thembtnghecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String fileAddress = (String) request.getAttribute("fileAddress");
		String id = (String) request.getAttribute("id");
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File(fileAddress));
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(fi));
			Sheet s = wb.getSheetAt(0);
			for(int i = 1 ; i <= s.getLastRowNum() ; i++)
			{
				Row r = s.getRow(i);
				DAOlistenquestion.insertlistenquestion(new listenquestion(0,r.getCell(0).getStringCellValue(), 
						r.getCell(1).getStringCellValue(),r.getCell(2).getStringCellValue(), r.getCell(3).getStringCellValue(),
						r.getCell(4).getStringCellValue(),  r.getCell(5).getStringCellValue(),  r.getCell(6).getStringCellValue(),r.getCell(7).getStringCellValue(), 
						r.getCell(7).getStringCellValue(), Integer.parseInt(id)));
			}		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		RequestDispatcher r = request.getRequestDispatcher("Hienthidsquanlybtnghe?pageid=1");
		r.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(request, response);
	}
}
