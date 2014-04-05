package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class DoSql
 */
@WebServlet("/AcceptProposal")
public class AcceptProposal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptProposal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
     	DbCon a = new DbCon();
     	String id = request.getParameter("contract_id").toString();
		Statement st = a.getStatement();
		String statement = "Update `contracts` SET `status` = 'abgeschlossen' where `id` = '" + id +"'";
		System.out.println(statement);
	
	  st.executeUpdate(statement);  
		
	
	} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		
		request.setAttribute("success", "yes");
		response.sendRedirect("GetProposals");
//		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/context/main.jsp");
//	    rd.forward(request, response);
	   
}
		

	
	
	
	
	
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	    	doGet(request,response);
	    	
	    	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
