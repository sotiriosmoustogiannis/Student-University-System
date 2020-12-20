<%-- 
    Document   : page4
    Created on : 10 Ιουν 2018, 9:35:49 μμ
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>foithtes</title>
    </head>
    <body>
        <h1>Καλωσήρθατε!</h1>
       <h2>Προβολή βαθμολογίας ανά μάθημα:</h2> 
       <form id="courseview" name="view" method="get" action="StudentsServl">
           
          
           <br> <input type="submit" value="Προβολή" name="ShowCourses"/>
            </form>
    <br><br></br>
    <h2>Προβολή μέσου όρου βαθμολογίας ανά εξάμηνο</h2> 
       <form id="courseview2" name="view2" method="post" action="StudentsServl">
           
          
           <br> <input type="submit" value="Προβολή Μ.Ο. εξαμήνου" name="ShowCourses"/>
            </form>
    <br><br></br>
    <h2>Προβολή μέσου όρου βαθμολογίας:</h2>
    <br><br></br>
    
    <form id="courseview1" name="view1" method="get" action="StudentsServl2">
            <br> <input type="submit" value="Προβολή M.O." name="ShowCourses"/>
            </form>
    
             <br><br>
             <form id="loginform" name="logout" method="get" action="LogoutServl">
            <br> <input type="submit" value="ΑΠΟΣΥΝΔΕΣΗ" name="logout" align="left"/>
            </form>
    </body>
</html>