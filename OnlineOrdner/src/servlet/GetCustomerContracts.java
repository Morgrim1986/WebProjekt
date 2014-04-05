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
@WebServlet("/GetCustomerContracts")
public class GetCustomerContracts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String U_DIRECTORY = "Documents/"; 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerContracts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		ArrayList<Contracts> arrayList = new ArrayList<Contracts>();
		
		System.out.println(request.getParameter("go").toString());
		try {
     	DbCon a = new DbCon();
		Statement st = a.getStatement();
     	ResultSet res = st.executeQuery("Select * from contracts where user = '"+ request.getParameter("go").toString()+"'");
		
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

  	response.sendRedirect("context/customer_contracts.jsp");

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
