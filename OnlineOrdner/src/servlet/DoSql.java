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
		ArrayList<CusAdditional> arrayList_additional = new ArrayList<CusAdditional>();
	
		try {
     	DbCon a = new DbCon();
		Statement st = a.getStatement();
		HttpSession session = request.getSession();
		ResultSet res;
		ResultSet res_add;
		
		if ( !request.getParameterMap().containsKey("user")){
		
		res = st.executeQuery("Select * from contracts where user = '"+ session.getAttribute("user")+"'");
		}
		else{
			
		
		
		res_add = st.executeQuery("Select * from has_add_documents where username_cus = '"+ request.getAttribute("user")+"' and username_ver = '" + request.getSession().getAttribute("user").toString() + "'");
		
		while (res_add.next()) {              
		       
			CusAdditional cus_add = new CusAdditional();
			cus_add.setDocument(res_add.getString(3));
			cus_add.setType(res_add.getString(4));
			arrayList_additional.add(cus_add);
			
			
		}
		res = st.executeQuery("Select * from contracts where user = '"+ request.getAttribute("user")+"'");
		
		}
		
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
		request.getSession().setAttribute("list_add", arrayList_additional);
		if ( !request.getParameterMap().containsKey("user")) {
		  	response.sendRedirect("context/contracts.jsp");}
		else{
			response.sendRedirect("context/customer_contracts.jsp");
		}
 	
	}
		
		else if (request.getAttribute("operation") == "upload"){
			
			if ( !request.getParameterMap().containsKey("user")) {
			insertDocument(U_DIRECTORY + request.getAttribute("file"), request.getSession().getAttribute("user").toString(), request.getAttribute("type").toString());
			}
			else{
				
				if ( !request.getParameterMap().containsKey("add_upload")) {
					insertDocument(U_DIRECTORY + request.getAttribute("file"), request.getAttribute("user").toString(), request.getAttribute("type").toString());
				}
				else{
					System.out.println(request.getSession().getAttribute("user").toString());
					System.out.println( request.getParameter("user").toString());
					System.out.println( U_DIRECTORY + request.getAttribute("user").toString() + request.getAttribute("file"));
					System.out.println(request.getAttribute("type").toString());
					
					insertDocumentAdd(request.getSession().getAttribute("user").toString(), request.getAttribute("user").toString(), U_DIRECTORY + request.getAttribute("user").toString() + "/" + request.getAttribute("file"), request.getAttribute("type").toString());	
				}
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("message", request.getAttribute("message"));
			if (request.getParameterMap().containsKey("user")) {
			request.setAttribute("user", request.getParameter("user").toString());
			}
			request.removeAttribute("operation");
			getServletContext().getRequestDispatcher("/DoSql").forward(request, response);
				
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
	
		
	
	protected void insertDocumentAdd(String user_ver, String user_cus, String document, String type){
		
			
		try {
	     	DbCon a = new DbCon();
			Statement st = a.getStatement();
			String statement = "Insert Into `has_add_documents`(`username_ver`, `username_cus`, `document`, `type`) VALUES ('" + user_ver + "','" + user_cus + "','" + document + "','" + type + "')";
			System.out.println(statement);
					
			st.executeUpdate(statement);  
	
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
