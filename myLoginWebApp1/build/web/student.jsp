<%-- 
    Document   : student
    Created on : Dec 5, 2016, 11:49:32 AM
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
        <h1>Welcome <% 
            String user = (String)session.getAttribute("u");
            out.println(user); 
        %> 
        </h1>
        <br><br>
        
        <a href="">Contact Us</a><br><br>
        <a href="updateprofile?uid=<% out.println(user);%>">Update Profile</a><br>
        <%
            request.getAttribute("u");
        %>
        </center>
    </body>
</html>
