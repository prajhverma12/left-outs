/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prajwal
 */
public class updateprofile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String user_id = request.getParameter("uid");
             
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
            PreparedStatement pst = con.prepareStatement("select * from student_info where login_id=?");
            pst.setString(1, user_id);
            ResultSet rs = pst.executeQuery();
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateprofile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<form action='updateServlet'>");
            while(rs.next())
            {
                out.println("<input type='text' value="+rs.getString(1)+" name='uid' readonly='true'/><br><br>");
                out.println("<input type='text' value="+rs.getString(2)+" name='name' /><br><br>");
                out.println("<input type='text' value="+rs.getString(3)+" name='adress' /><br><br>");
                out.println("<input type='text' value="+rs.getString(4)+" name='email' /><br><br>");   
            }
            out.println("<input type='submit' name='submit' value='Upadte'>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
         catch(Exception e)
        {
            System.out.println(e);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

}

