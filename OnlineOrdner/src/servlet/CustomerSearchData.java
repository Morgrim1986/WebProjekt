package servlet;

    
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

	 
	public class CustomerSearchData {
	    
		private int totalCustomers;
	    private String data;
	    private List<String> customers;
	  
	    public CustomerSearchData(String user) {
	    	
	    	customers = new ArrayList<String>();
	    
	    	try {
	         	DbCon a = new DbCon();
	    		Statement st = a.getStatement();
	    		ResultSet res = st.executeQuery("Select u.firstname, u.lastname from users as u INNER JOIN has_customer as h ON u.username = h.customer where h.user = '"+ user +"'");
	    		
	    		while (res.next()) {              
	    	       
	    			if (data == null){
	    			data = res.getString(1) + ", ";	
	    			}
	    			else{
	    			
	    			 data = data + res.getString(1) + ", ";
	    			}
	    		}
	    		
	    	
	    	} catch (InstantiationException | IllegalAccessException
	    				| ClassNotFoundException | SQLException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    	}
	    	
	    	    	
	    	
	    	StringTokenizer st = new StringTokenizer(data, ",");
	         
	        while(st.hasMoreTokens()) {
	            customers.add(st.nextToken().trim());
	        }
	        totalCustomers = customers.size();
	    	
	      	}
	    	
	      
	     
	    public List<String> getData(String query) {
	        String customer = null;
	        query = query.toLowerCase();
	        List<String> matched = new ArrayList<String>();
	        for(int i=0; i<totalCustomers; i++) {
	            customer = customers.get(i).toLowerCase();
	            if(customer.startsWith(query)) {
	                matched.add(customers.get(i));
	            }
	        }
	        return matched;
	    }
	}