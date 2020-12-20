<%-- 
    Document   : Page2
    Created on : 4 Ιουν 2018, 7:56:32 μμ
    Author     : user
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Γραμματεία</title>
    </head>
    <body>
        <h1>Καλωσήρθατε!</h1>
            <h2>Εμφανισή μαθημάτων:</h2> 
            <form id="loginform" name="search" method="post" action="AddCourseServl">
            <br> <input type="submit" value="Μαθήματα" name="ShowCourses"/>
            </form>
            
            
            <h4></h4>
            </form>
            
            
             <h2>Προσθήκη νέου μαθήαμτος</h2>
            
<form  name="newCourse" method="get" action="AddCourseServl">
<table align="left">
<tr><td align="left">*Κωδικός μαθήματος:</td><td><input type="text"  name="Course_id" align="center" required /></td></tr>
<tr><td align="left">*Όνομα μαθήματος:</td><td><input type="text" name="Course_name" align="center" required /></td></tr>
<tr><td align="left">*Υπεύθηνος Καθηγητής(ID):</td><td><input type="text"  name="Prof_id" align="center" required /></td></tr>
<tr><td align="left">*Εξάμηνο:</td><td><input type="text" name="Semester" align="center" required /></td></tr>
<br> <input type="submit" value="ΠΡΟΣΘΗΚΗ"/>



</table>
    
</form>
             
             <br><br><br><br><br>
             <form id="loginform" name="logout" method="get" action="LogoutServl">
            <br> <input type="submit" value="ΑΠΟΣΥΝΔΕΣΗ" name="logout" align="left"/>
            </form>

    </body>
</html>

