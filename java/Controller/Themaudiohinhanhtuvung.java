package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Themaudiohinhanhtuvung
 */
@WebServlet("/Themaudiohinhanhtuvung")
public class Themaudiohinhanhtuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themaudiohinhanhtuvung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher r = request.getRequestDispatcher("Admin/Themaudiohinhanhtuvung.jsp");
		r.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // TODO Auto-generated method stub
				//doGet(request, response);
				ServletContext context = request.getServletContext();
				final String Address =  context.getRealPath("FileAudioImageVocabulary/");

				
				final int MaxMemorySize = 1024 * 1024 * 5; //5MB
				final int MaxRequestSize = 1024 * 1024 * 50; //50 MB
				
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				
				if (!isMultipart)
				{
					request.setAttribute("message","not have enctypr: multipart/form-data");	
				}
				
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				
				// Set factory constraints
				factory.setSizeThreshold(MaxMemorySize);

				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
				
				
				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				
				// Set overall request size constraint
				upload.setSizeMax(MaxRequestSize);
				//System.out.println("ad");
				
				
				try 
				{
					// Parse the request
					List<FileItem> items = upload.parseRequest(request);
					
					// Process the uploaded items
					Iterator<FileItem> iter = items.iterator();
					
					while (iter.hasNext()) 
					{
					    FileItem item = iter.next();

					    if (!item.isFormField()) 
					    {
					    	 String fileName = item.getName();
					    	 
					    	 //pathFile: vị trí mà chúng ta muốn upload file vào
					    	 //gửi cho server
					    	 
					        String pathFile = Address + fileName;
					    	System.out.println(pathFile);
					    	File uploadedFile = new File(pathFile);
					    	boolean kt = uploadedFile.exists();
					    	 
					    	try 
					    	{
					    		if (kt == true)
					    		{
					    			request.setAttribute("message","File "+fileName+" exist");	
				
					    		
					    			RequestDispatcher rd = request.getRequestDispatcher("Hienthidstuvung?pageid=1");
						    		rd.forward(request,response);
									
					    		}
					    		else
					    		{
					    			item.write(uploadedFile);
									request.setAttribute("message","Upload file success");	
									System.out.println("Them thanh cong");	
									RequestDispatcher r = request.getRequestDispatcher("Hienthidstuvung?pageid=1");
								    r.forward(request, response);
					    		}
							} 
					    	catch (Exception e) 
					    	{

					    		request.setAttribute("message",e.getMessage());	
					    		RequestDispatcher rd = request.getRequestDispatcher("Hienthidstuvung?pageid=1");
					    		rd.forward(request,response);
								
							}
					    } 
					    else 
					    {
					    	request.setAttribute("message","Upload file failed");	
					    }
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		
	}

}
