<%-- 
    Document   : page5
    Created on : 12 Ιουν 2018, 12:36:27 πμ
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>kathightes</title>
    </head>
    <body>
        <h1>Καλωσήρθατε!</h1>
            <h2>Προβολή λίστας μαθημάτων:</h2> 
            <form id="loginform" name="search" method="post" action="ProfessorsServl">
            <br> <input type="submit" value="Προβολή" name="ShowCourses"/>
            </form><br><br>
            <h2>Καταχώρηση βαθμολογίας:</h2> 
            <form id="loginform" name="search" method="get" action="ProfessorsServl">
            <table align="left">
            <tr><td align="left">*Κωδικός φοιτητή:</td><td><input type="text"  name="REGNUMBER" align="center" required /></td></tr>
            <tr><td align="left">*Κωδικός μαθήματος:</td><td><input type="text" name="COURSEID" align="center" required /></td></tr>
            <tr><td align="left">*Βαθμός:</td><td><input type="text"  name="GRADE" align="center" required /></td></tr>
            <br> <input type="submit" value="Καταχώρηση" name="Insertgrades"/>
            </table>
            </form>
           
           
             <br><br><br><br><br>
             <form id="loginform" name="logout" method="get" action="LogoutServl">
            <br> <input type="submit" value="ΑΠΟΣΥΝΔΕΣΗ" name="logout" align="left"/>
            </form>
           
    </body>
</html>