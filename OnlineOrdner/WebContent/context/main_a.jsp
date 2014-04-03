<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Compressed 
Description: A three-column, fixed-width template fit for 1024x768 screen resolutions.
Version    : 1.0
Released   : 20080524

-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>

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
			<form method = post name ="customers">
			<table style="border-spacing:10px;" border="0" cellpadding="25" cellspacing="0">
	
			 
			 <tr>
			 <td>   
			  <a href="customer_search.jsp" title="Meine Kunden">Meine Verträge</a>
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
		<div class="post">
			<h1 class="title">Willkommen <% if (session.getAttribute("user") != null){%> <%=session.getAttribute("gender").toString()%><% ; } %>!</a></h1>
			<div class="entry">
				<p> Dies ist ihr persönlicher Bereich ihres Online Ordners!</p>
				<h2>Kategorien</h2>
				<p>Diese Seite kann individuell gestaltet werden</p>
				<ul>
					<li>NEWS</li>
					<li>INFORMATIONEN</li>
					<li>KOOPERATIONEN</li>
					<li>AKTIONEN</li>
				</ul>
				<h3>Blogs auch möglich</h3>
			
				<blockquote>
					<p>&ldquo;Hier können Sie Blogeinträge oder sonstiges verwalten!&rdquo;</p>
				</blockquote>
				
				<h2>News und Informationen</h2>
				<p>Hier können aktuelle Statusmeldungen angezeigt werden und Informationen abegrufen die auf den User abgestimmt sind!</p>
				
				<h2>Aktuelle Angebot</h2>
				<p>Interessante Angebote genau auf Sie abgestimmt!</p>
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
		
	
	<!-- end sidebar2 -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<div id="footer">
	<p class="legal">&copy;Copyright by Profanter Versicherungen <a href="http://www.onlineordner.at/">OnlineOrdner.at</a></p>
</div>
</body>
</html>
