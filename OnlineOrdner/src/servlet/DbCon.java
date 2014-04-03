package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCon {
	
	Connection con;
	Statement st;
	
	public  DbCon() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection("jdbc:mysql://localhost/onlineordner","admin","admin");
	    st = con.createStatement();
		
	}
	
	public void ConKill() throws SQLException{
		
		con.close();
		
		
	}
	
	public Statement getStatement(){
	return this.st;
	}
}
