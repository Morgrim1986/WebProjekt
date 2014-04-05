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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
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
	
	<script type="text/javascript">
	$("#sidebar1").load("leftbar.html");
			</script>
			
	</div>
	<!-- end sidebar1 -->
	<!-- start content -->
	<div id="content">
	<div class="bgtop">
	<div class="bgbtm">
		<div class="post" min-height:60px>
			<h1 class="title">Verträge</a></h1>
			<p></p>
			 <table class="TFtable" border="1" width="490" height="30" cellspacing="3" cellpadding="5" >
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
<td colspan="100%"><form action="../UploadServlet" method="post" enctype="multipart/form-data">
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

<tr><td colspan="100"> ${sessionScope.message} </td></tr>
<c:remove var="message" scope="session" />

</table>		
	
	
			
			<div class="entry">
				<p> Dies ist ihr persönlicher Bereich ihres Online Ordners!</p>
				<h2>Kategorien</h2>
				<p>Diese Seite kann individuell gestaltet werden!!!!!!!</p>
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
		
		
			<script type="text/javascript">
$("#sidebar2").load("rightbar.html >*");
			</script>
			
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
