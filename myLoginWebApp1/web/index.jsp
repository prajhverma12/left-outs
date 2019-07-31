<%-- 
    Document   : index
    Created on : Dec 4, 2016, 11:43:51 PM
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
        <h1>Welcome </h1><br><br>
        <form action="loginValidateServlet">
            Username : <input type = "text" name="textUser"><br><br>
            Password : <input type="Password" name="textPass"><br><br>
            <input type="Submit" name="Login" value="Login">   
        </form>
        <br><a href="register.html"> Register </a>
        <br><br>
        <%
            if(session.getAttribute("msg")!=null)
            {
                out.println(session.getAttribute("msg"));
            }
        %>
        </center>
        
    </body>
</html>
