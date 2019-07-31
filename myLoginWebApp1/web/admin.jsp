<%-- 
    Document   : admin.jsp
    Created on : Dec 5, 2016, 11:15:40 AM
    Author     : Prajwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="text-align:center">
        <h1>Welcome <%
                        if(session.getAttribute("u")==null)
                        {
                            session.setAttribute("msg", "Your session has expired.Please login again");
                            response.sendRedirect("index.jsp");
                        }
                        out.print(session.getAttribute("u"));
                        session.setMaxInactiveInterval(10);
                %>
        </h1>
         <br><br>
         
             <a href="showallServlet">Show all Record </a><br><br>
             <a href="delete.jsp">Delete record </a><br><br>
             <a href="changepass.jsp">Change Password </a><br><br>
             <a href="index.jsp">Log out</a>
                     
    </body>
</html>
