<%-- 
    Document   : changepass
    Created on : Dec 6, 2016, 3:16:50 PM
    Author     : Prajwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>Change Password</h1> 
        <br><br>
        <form action="changePassServlet">
        Login ID = <input type="text" name="cu"><br><br>
        New Password = <input type="password" name ="newpass"><br><br>
        <input type="submit" name="change" value="Change"><br>
        </form>
        </center>
    </body>
</html>
