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
		ArrayList<Customers> arrayList_names = new ArrayList<Customers>();
		ArrayList<CusAdditional> arrayList_additional = new ArrayList<CusAdditional>();
			
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

		 ResultSet res_names = st.executeQuery("Select firstname, lastname from users where username = '"+ request.getParameter("go").toString()+"'");
		 
		while (res_names.next()) {              
		       
			Customers cus = new Customers();
			cus.setfirstname(res_names.getString(1));
			cus.setLastname(res_names.getString(2));
			arrayList_names.add(cus);
			
			
		}
		
		
		 ResultSet res_add_documents = st.executeQuery("Select * from has_add_documents where username_cus = '"+ request.getParameter("go").toString()+"' and username_ver = '" + request.getSession().getAttribute("user").toString() + "'");
		 
			while (res_add_documents.next()) {              
			       
				CusAdditional cus_add = new CusAdditional();
				cus_add.setDocument(res_add_documents.getString(3));
				cus_add.setType(res_add_documents.getString(4));
				arrayList_additional.add(cus_add);
				
				
			}
		
		
	
	} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		
		request.getSession().setAttribute("list", arrayList);
		request.getSession().setAttribute("list_names", arrayList_names);
		request.getSession().setAttribute("list_add", arrayList_additional);
		System.out.println( request.getParameter("go").toString());
		request.setAttribute("user", request.getParameter("go").toString());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/context/customer_contracts.jsp");
	    rd.forward(request, response);
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
