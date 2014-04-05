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
@WebServlet("/GetProposals")
public class GetProposals extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProposals() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		ArrayList<Contracts> arrayList = new ArrayList<Contracts>();
				
		try {
     	DbCon a = new DbCon();
		Statement st = a.getStatement();
     	ResultSet res = st.executeQuery("Select * from contracts where user = '"+ request.getSession().getAttribute("user").toString() +"' and status = 'offen'");
     	
		
		while (res.next()) {              
	       
	            Contracts contract = new Contracts();
	            contract.setContract_type(res.getString(3));
	            contract.setId(res.getInt(1));
	            contract.setDocument(res.getString(5));
	            arrayList.add(contract);
	        
	           
		}

	
		
	
	} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		
		request.getSession().setAttribute("list", arrayList);
		response.sendRedirect("context/main.jsp");
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
