1<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OnlineOrdner.at - Login</title>

<link href="login-box.css" rel="stylesheet" type="text/css" />
</head>

<body>


<div style="padding: 100px 0 0 250px;">


<div id="login-box">
<form method="post" name="login" action="LoginCheck"> 
<H2>Login</H2>
Willkommen zu www.OnlineOrdner.at! Ihr Versicherungs-Webservice! Bitte loggen Sie sich ein!
<br />
<br />
<div id="login-box-name" style="margin-top:20px;">Benutzername:</div><div id="login-box-field" style="margin-top:20px;"><input name="loginName" class="form-login" title="Benutzername" value="andrea" size="30" maxlength="2048" /></div>
<div id="login-box-name">Passwort:</div><div id="login-box-field"><input name="password" type="password" class="form-login" title="Password" value="andi" size="30" maxlength="2048" /></div>
<br />
<span class="login-box-options"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px;">Forgot password?</a></span>
<br />
<br />
<input type="submit" name="contracts" value="" style="background: url('images/login_button.png');width:103px;height:42px; border:0; margin-left:90px;"/>" 
</form>

</div>

</div>


</body>
</html>
