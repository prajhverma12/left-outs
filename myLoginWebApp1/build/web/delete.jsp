<%-- 
    Document   : delete.jsp
    Created on : Dec 6, 2016, 2:18:11 PM
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
        <h1>Delete Record</h1><br><br>
        <form action="deleteServlet">
        Login Id : <input type="text" name="du"><br><br>
        <input type="submit" name="delete" value="delete">
        </form>
        </center>
    </body>
</html>
