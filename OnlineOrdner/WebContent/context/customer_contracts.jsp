<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>

<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8"; />
<title>OnlineOrdner-Main</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>


	<div id="page">
	<div id="logo">
	Eingeloggt als: <strong><% if (session.getAttribute("user") != null){%> <%= session.getAttribute("user").toString()%><% ;} %> | <a href="/OnlineOrdner/LogOut">Abmelden</a></strong> </p>
	</div>
<!-- end #header -->
	<!-- start sidebar1 -->
	<div id="sidebar1" class="sidebar">
	<ul>
		<h2>Kategorien</h2>
			<li>	
			<form method = post name ="customers" action = "../GetCustomers">
			<table style="border-spacing:10px;" border="0" cellpadding="25" cellspacing="0">
	
			 
			 <tr>
			 <td>   
			  <a href="../GetCustomers" title="Meine Kunden">Meine Verträge</a>
			 </td>
			 </tr>
			  
			<tr>
			 <td>   
			 <input type="submit" name="appointments" value="" style="background: url('images/buttons/appointments.png');width:55px;height:55px;border:0"/>
			 </td>
			 </tr>
			    
			    
			 <tr>
			 <td> 
		     <a href="" title="Meine Termine">Meine Termine</a> 
            </td>
		  </tr>
		  
		  	 <tr>
			 <td>   
			 <input type="submit" name="finance" value="" style="background: url('images/buttons/finance.png');width:55px;height:55px;border:0"/>
			 </td>
			 </tr>
			    
			    
			 <tr>
			 <td> 
		     <a href="" title="Meine Finanzen">Meine Finanzen</a> 
            </td>
		  </tr>
		  
		  
		  	  	 <tr>
			 <td>   
			 <input type="submit" name="email" value="" style="background: url('images/buttons/email.png');width:55px;height:50px;border:0"/>
			 </td>
			 </tr>
			    
			    
			 <tr>
			 <td> 
		     <a href="" title="Posteingang">Posteingang</a> 
            </td>
		  </tr>
		  
		  
			 <tr>
			 <td>   
			 <input type="submit" name="data" value="" style="background: url('images/buttons/userdata.png');width:55px;height:55px;border:0"/>
			 </td>
			 </tr>
			    
			    
			 <tr>
			 <td> 
		     <a href="" title="Meine Daten">Meine Daten</a> 
            </td>
		  </tr>
	    
			    </tr>
			  </table>
			</form>
		</li>
	</ul>
		
	</div>
	<!-- end sidebar1 -->
	<!-- start content -->
	<div id="content">
	<div class="bgtop">
	<div class="bgbtm">
		<div class="post" min-height:60px>
			<h1 class="title">Verträge von <c:forEach items="${sessionScope.list_names}" var="list"> <c:out value="${list.firstname}" />  <c:out value="${list.lastname}"/></c:forEach></h1>
			<h2>${sessionScope.message}</h2>
			<c:remove var="message" scope="session" />
			<p></p>
			 <table border="1" width="490" height="30" cellspacing="3" cellpadding="5">
<tbody>
<tr>
<th align="center">ID</th>
<th align="center">Vertragsart</th>
<th align="center">Status</th>
<th align="center">Dokument</th>
</tr>

	
<c:forEach items="${sessionScope.list}" var="list">
<tr><td><c:out value="${list.id}"/></td> 
<td><c:out value="${list.contract_type}"/></td>
<td><c:out value="${list.status}"/></td> 
<td><form method = post name ="contracts" action = "${list.document}">
<input type="submit" name="pdf" value="" align="center" style="background: url('images/pdf_small.jpg');width:25px;height:25px;border:0"/>
</form></td></tr>
</c:forEach>
</tbody>
	
<tr>
<td colspan="100%"><form action="UploadServlet" method="post" enctype="multipart/form-data">
<input type="hidden" name="user" value="${requestScope.user}">
    <select size="1" name="description" />
      <option>Unfallversicherung</option>
      <option>Lebensversicherung</option>
      <option>Krankenversicherung</option>
      <option>Pensionsversicherung</option>
      <option>Freizeitversicherung</option>
    </select>
    <input type="file" name="file" />
    <input type="submit" />
</form>
</td>
</tr>
</table>		
	
	
<h1 class="title">Dokumente für <c:forEach items="${sessionScope.list_names}" var="list"> <c:out value="${list.firstname}" />  <c:out value="${list.lastname}"/></c:forEach></h1>

<table border="1" width="490" height="30" cellspacing="3" cellpadding="5">
<tbody>
<tr>
<th align="center">Dokumentart</th>
<th align="center">Dokumentlink</th>
</tr>

	
<c:forEach items="${sessionScope.list_add}" var="list">
<tr><td><c:out value="${list.type}"/></td> 
<td><form method = post name ="contracts" action = "${list.document}">
<input type="submit" name="pdf" value="" align="center" style="background: url('images/pdf_small.jpg');width:25px;height:25px;border:0"/>
</form></td></tr>
</c:forEach>
</tbody>
	
<tr>
<td colspan="100%"><form action="UploadServlet" method="post" enctype="multipart/form-data">
<input type="hidden" name="user" value="${requestScope.user}">
<input type="hidden" name="add_upload" value="upload">
    <select size="1" name="description" />
      <option>Mail</option>
      <option>Word</option>
      <option>Anfrage</option>
      <option>Angebot</option>
    </select>
   <input type="file" name="file" />
   <input type="submit" />
</form>
</td>
</tr>
</table>
			
			<div class="entry">
			
			</div>
			<p class="tags"><strong>Tags: </strong><a href="#">Versicherung</a> <a href="#">Haushalt</a> <a href="#">Unfall</a> <a href="#">KFZ</a></p>
		<!-- 	<p class="links">Posted in <a href="#" title="View all posts in Free WP Themes" rel="category">Uncategorized</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a href="#" title="Edit post">Edit</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a href="#" title="Comment on About This Theme">4 Comments</a></p>  -->
		</div>
	</div>
	</div>
	</div>
<!-- end content -->
	<!-- start sidebar2 -->
	<div id="sidebar2" class="sidebar">
	
</div>
		
	</div>
	<!-- end sidebar2 -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<div id="footer">
	<p class="legal">&copy;Copyright by Profanter Versicherungen <a href="http://www.onlineordner.at/">OnlineOrdner.at</a></p>
</div>
</body>
</html>
