<%-- 
    Document   : index
    Created on : Dec 11, 2016, 2:23:35 PM
    Author     : Prajwal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css0.css" rel="stylesheet">
    </head>
    <body>
        <sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/task" user="root" password="password"/>
        <sql:query sql="select * from country" var="result"/>
        <div id="top">
        </div>
        <div id="middle">
            <form onsubmit="return validateform()">
            User Name : <input type="text" name="name" id="name"><br><br>
            Email ID : <input type="text" name="email" id="email"><br><br>
            Contact no : <input type="text" name="contact"><br><br>
            Country : <select id="country" name="country" onchange="getstate()">
                <option value=""><----Country----></option>
                    <core:forEach var="data" items="${result.rows}">
                        <option>${data.name}</option>
                    </core:forEach>
            </select>
           
            
            <br><br><input type="submit" name="submit" value="Submit">
        </form>
        </div>
        <div id="bottom">
                Copyright &#169; Prajwal Verma
            </div>
        
    </body>
</html>
