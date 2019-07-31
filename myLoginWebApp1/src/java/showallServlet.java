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
public class showallServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showallServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
            PreparedStatement pst = con.prepareStatement("select * from login order by "+ request.getParameter("sortby"));
            ResultSet rs = pst.executeQuery();
            out.print("<table border = '1'>");
            out.print("<tr>");
            out.print("<td>");out.print("<a href='?sortby=login_id'>");out.print("<b>");out.print("Login ID");out.print("</b>");out.print("</a>");
            out.print("<td>");out.print("<a href='?sortby=password'>");out.print("<b>");out.print("Password");out.print("</b>");out.print("</a>");
            out.print("<td>");out.print("<a href='?sortby=type'>");out.print("<b>");out.print("Type");out.print("</b>");;out.print("</a>");
            out.print("</tr>");
            while(rs.next())
            {
                out.print("<tr>");
                out.print("<td>");
                out.print(rs.getString(1));out.print("");
                out.print("<td>");out.print(rs.getString(2));
                out.print("<td>");out.println(rs.getString(3));
                out.print("</tr>");
            }
            out.print("</table>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
