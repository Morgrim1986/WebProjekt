package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


/**
 * Servlet implementation class Counter
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String gender = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("loginName");
		String pass = request.getParameter("password");

	
				try {
					DbCon a= new DbCon();
					Statement st = a.getStatement();
					ResultSet res = st.executeQuery("Select * from users where username = '"+user+"'");
					
					if(res.last() == false)
					{
						request.getRequestDispatcher("index.jsp").forward(request, response);}
						else{
							res.beforeFirst();
						}
						
							
					while (res.next()){
						System.out.println(pass.isEmpty());
						if ((res.getString("password").compareTo(pass) == 0) & (pass.isEmpty() != true)){
							
						if (res.getString("gender").compareTo("1") == 0){
							gender = "Herr " + res.getString("firstname") + " " +res.getString("lastname");
						}
							else {
								gender = "Frau " + res.getString("firstname") + " " + res.getString("lastname");
							}
							
						
						
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						session.setAttribute("gender", gender);
						session.setMaxInactiveInterval( 2 * 60);
						
						Cookie userName = new Cookie( "user", user);
						userName.setMaxAge(2 * 60);
						response.addCookie(userName);
						response.sendRedirect("context/main.jsp");
						
									
						}
						else {response.sendRedirect("index.jsp");}
						
						
					}
					
				
					
				} catch (SQLException e) {

					// TODO Auto-generated catch block
				   e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
