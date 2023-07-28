package Controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.security.auth.callback.ConfirmationCallback;
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

import BEAN.vocabularycontent;
import DAO.DAOvocabularycontent;

/**
 * Servlet implementation class Themndchudetuvung
 */
@WebServlet("/Themndchudetuvung")
public class Themndchudetuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themndchudetuvung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String vocabularyguidelineid = request.getParameter("vocabularyguidelineid");
		request.setAttribute("vocabularyguidelineid", vocabularyguidelineid);
		RequestDispatcher r = request.getRequestDispatcher("Admin/Themndchudetuvung.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String vocabularyguidelineid = (String) request.getAttribute("id");
	    String fileAddress = (String) request.getAttribute("fileAddress");
	    DAOvocabularycontent.deleteByID(Integer.parseInt(vocabularyguidelineid));
	   //DAOvocabularycontent.deleteByID(Integer.parseInt(vocabularyguidelineid));
	    
	    FileInputStream fi;
	    try {
			fi = new FileInputStream(fileAddress);
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(fi));
		    Sheet s = wb.getSheetAt(0);
		    
		    for(int i = 1 ; i  <= s.getLastRowNum(); i++)
		    {
		    	Row r = s.getRow(i);
		    	String vocabularycontentname = r.getCell(0).getStringCellValue();
		    	String transcribe = r.getCell(1).getStringCellValue();
		    	String audiomp3 = r.getCell(2).getStringCellValue();
		    	String audiogg = r.getCell(3).getStringCellValue();
		    	String mean = r.getCell(4).getStringCellValue();
		    	
		    	DAOvocabularycontent.insertVocab(new vocabularycontent(0, vocabularycontentname, transcribe, 
		    			audiomp3, audiogg, mean, Integer.parseInt(vocabularyguidelineid)));
		    }	
		} catch (Exception e) {
          e.printStackTrace();
		}	
	    RequestDispatcher r = request.getRequestDispatcher("Hienthidstuvung?pageid=1");
	    r.forward(request, response);
	}
}
