<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="servlet.CustomerSearchData"%>
<%
    CustomerSearchData db = new CustomerSearchData(session.getAttribute("user").toString());
 
    String query = request.getParameter("q");
     
    List<String> customers = db.getData(query);
 
    Iterator<String> iterator = customers.iterator();
    while(iterator.hasNext()) {
        String customer = (String)iterator.next();
        out.println(customer);
    }
%>