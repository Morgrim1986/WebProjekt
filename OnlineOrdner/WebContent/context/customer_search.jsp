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
 <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script src="js/jquery.autocomplete.js"></script>  
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
			<form method = post name ="customers" action = "../DoSql">
			<table style="border-spacing:10px;" border="0" cellpadding="25" cellspacing="0">
	
			 
			 <tr>
			 <td>   
			  <a href="" title="Meine Kunden">Meine Verträge</a>
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
		
		<h1>Benutzer</h1>
    <input type="text" id="customer" name="customer"/>
     
    <script>
        $("#customer").autocomplete("getdata.jsp");
    </script>
		
		
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
