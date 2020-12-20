<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Γραματεία Πανεπηστημίου Πειραιώς </h1>
<left>
    <h2>Παρακαλώ συνδεθείτε για να συνεχίσετε!</h2> 
   
<form id="loginform" name="PersonalData" method="post" action="SecretariesServl">
<table align="left">
<tr><td align="left">*Username:</td><td><input type="text"  name="username" align="center" required /></td></tr>
<tr><td align="left">*Password:</td><td><input type="password" name="password" align="center" required /></td></tr>




</table>
<br> <input type="submit" value="ΣΥΝΔΕΣΗ"/>

</form>

</left>
</body>
</html>