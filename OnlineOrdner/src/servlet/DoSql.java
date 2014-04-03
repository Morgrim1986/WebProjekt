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
@WebServlet("/DoSql")
public class DoSql extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String U_DIRECTORY = "Documents/"; 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSql() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		if (request.getAttribute("operation") != "upload") {
		
		
		ArrayList<Contracts> arrayList = new ArrayList<Contracts>(); 
	
		try {
     	DbCon a = new DbCon();
		Statement st = a.getStatement();
		HttpSession session = request.getSession();
		ResultSet res = st.executeQuery("Select * from contracts where user = '"+ session.getAttribute("user")+"'");
		
		while (res.next()) {              
	       
	            Contracts contract = new Contracts();
	            contract.setId(res.getInt(1));
	            contract.setContract_type(res.getString(3));
	            contract.setStatus(res.getString(4));
	            contract.setDocument(res.getString(5));
	            arrayList.add(contract);
	        
		
	        
		
		}
		
	
	} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		
		request.getSession().setAttribute("list", arrayList);
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/context/contracts.jsp");
  	response.sendRedirect("context/contracts.jsp");
  //      rd.forward(request, response);	
	}
		
		else if (request.getAttribute("operation") == "upload"){
			insertDocument(U_DIRECTORY + request.getAttribute("file"), request.getSession().getAttribute("user").toString(), request.getAttribute("type").toString());
			HttpSession session = request.getSession();
			session.setAttribute("message", request.getAttribute("message"));
			response.sendRedirect("DoSql");
				
		}
	}
	
	
	
	protected void insertDocument(String filename, String user, String type){
		
		int id = 0;
		String state = "offen";
	
		
		try {
	     	DbCon a = new DbCon();
			Statement st = a.getStatement();
			String statement = "Insert Into 'contracts'(`id`, `user`, `contract_type`, `status`, `document`) VALUES ('" + ( id+ 1) + "','" + user + "','" + state + "','" + type + "','" + filename+ "')";
			System.out.println(statement);
			ResultSet res = st.executeQuery("Select MAX(ID) from contracts");
			
			
			
			while (res.next()) {              
				id = res.getInt(1);
		                       }
			
		  st.executeUpdate("INSERT INTO `contracts` (`id`, `user`, `contract_type`, `status`, `document`) VALUES ('" + ( id+ 1) + "','" + user + "','" + type + "','" + state + "','" + filename+ "')");  
			
			
		
		} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
			

		
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
