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
@WebServlet("/GetCustomers")
public class GetCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String U_DIRECTORY = "Documents/"; 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		ArrayList<Customers> arrayList = new ArrayList<Customers>(); 
	
		try {
     	DbCon a = new DbCon();
		Statement st = a.getStatement();
		HttpSession session = request.getSession();
		ResultSet res = st.executeQuery("Select u.firstname, u.lastname, u.username from users as u INNER JOIN has_customer as h ON u.username = h.customer where h.user = '"+ session.getAttribute("user").toString()+"'");
		
		while (res.next()) {              
	       
	        Customers customers = new Customers();    
			
	            customers.setfirstname(res.getString(1));
	            customers.setLastname(res.getString(2));
	            customers.setUsername(res.getString(3));
	            arrayList.add(customers);
	    	}
		

	} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		
		request.getSession().setAttribute("list", arrayList);
		response.sendRedirect("context/customer_search.jsp");
	
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
