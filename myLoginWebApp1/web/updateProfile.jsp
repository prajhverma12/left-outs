<%-- 
    Document   : updateProfile
    Created on : Dec 11, 2016, 7:03:56 PM
    Author     : Prajwal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Update Profile</h1><br><br>
            
         <form>   
        <%
            String user_id = (String)request.getAttribute("uid");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
                PreparedStatement pst = con.prepareStatement("select * from student_info where login_id=?");
                pst.setString(1, user_id);
                ResultSet rs = pst.executeQuery();
                while(rs.next())
                {
        %>
        
        Login Id : <input type="text" value="<% out.println(rs.getString(1));%>" name="uid" readonly="true">
        Name : <input type="text" value="<% out.println(rs.getString(2));%>" name="uname" >
        Address : <input type="text" value="<% out.println(rs.getString(3));%>" name="address" >
        Email Id : <input type="text" value="<% out.println(rs.getString(4));%>" name="email" >
        <%      }
              }
                catch(Exception e)
                {
                    System.out.println(e);
                }
        %>
        <input type="submit" name="submit" value="Update">
         </form>
        </center>
    </body>
</html>
