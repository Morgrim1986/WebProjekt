package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB
				 maxFileSize=1024*1024*50,          // 50 MB
				 maxRequestSize=1024*1024*100)      // 100 MB

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "context\\Documents";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    String applicationPath = request.getServletContext().getRealPath("");
	    String uploadFilePath = applicationPath + File.separator + UPLOAD_DIRECTORY;
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    

	    if (getFilename(filePart).equals("") != true) {
	    
	    String filename = getFilename(filePart);
	 		
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            part.write(uploadFilePath + File.separator + filename);
        }     
	      
	   
        request.setAttribute("message", filename + " Datei wurde erfolgreich hochgeladen!");
        request.setAttribute("file", filename);
        request.setAttribute("type", description);
    	
        if (request.getParameterMap().containsKey("user") ){
        request.setAttribute("user", request.getParameter("user"));
        }
    	
    	if (request.getParameterMap().containsKey("add_upload")){  
	      request.setAttribute("add_upload", request.getParameter("add_upload"));
	      }
    	
        request.setAttribute("operation", "upload");   
        getServletContext().getRequestDispatcher("//DoSql").forward(request, response);
        
	    }
	    else{
	    	if ( !request.getParameterMap().containsKey("user")){
	    	   session.setAttribute("message", "Sie müssen zuerst eine Datei auswählen!");
	       	   response.sendRedirect("context/contracts.jsp");
	    	}
	    	   else{
	    	  session.setAttribute("message", "Sie müssen zuerst eine Datei auswählen!");
	    	  request.setAttribute("user", request.getParameter("user"));
	    	  if (request.getParameterMap().containsKey("add_upload")){  
	    	  request.setAttribute("add_upload", request.getParameter("add_upload"));
	    	  }
	    	  getServletContext().getRequestDispatcher("/context/customer_contracts.jsp").forward(request, response);
	    	  }
	    	
	     }
        
        
	}


   		private static String getFilename(Part part) {
		    for (String cd : part.getHeader("content-disposition").split(";")) {
		        if (cd.trim().startsWith("filename")) {
		            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
		            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
		        }
		    }
		    return null;
		}
	}


