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
 * Servlet implementation class Themcauhoibtdoc
 */
@WebServlet("/Themcauhoibtdoc")
public class Themcauhoibtdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themcauhoibtdoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String readexerciseid = request.getParameter("readexerciseid");
		request.setAttribute("readexerciseid", Integer.parseInt(readexerciseid));
		RequestDispatcher r = request.getRequestDispatcher("Admin/Themcauhoibtdoc.jsp");
	    r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		final String Address =  context.getRealPath("Filebtdoc/");
		String id = request.getParameter("readexerciseid");
		
		final int MaxMemorySize = 1024 * 1024 * 5; //3MB
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
			    			request.setAttribute("id", id);
			    			request.setAttribute("fileAddress", pathFile);
			    			
			    			
			    			RequestDispatcher rd = request.getRequestDispatcher("Thembtdoccontroller");
				    		rd.forward(request,response);
							
			    		}
			    		else
			    		{
			    			item.write(uploadedFile);
							request.setAttribute("message","Upload file success");	
							System.out.println("Them thanh cong");	
		
							
							request.setAttribute("fileAddress", pathFile);
						//	System.out.println(id);
							request.setAttribute("id", id);
							
							
							RequestDispatcher r = request.getRequestDispatcher("Thembtdoccontroller");
						    r.forward(request, response);
			    		}
					} 
			    	catch (Exception e) 
			    	{

			    		request.setAttribute("message",e.getMessage());	
			    		RequestDispatcher rd = request.getRequestDispatcher("Hienthidsbtdoc?pageid=1");
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
