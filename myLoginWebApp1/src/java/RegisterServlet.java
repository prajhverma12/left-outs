/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prajwal
 */
public class RegisterServlet extends HttpServlet {

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
        String name = request.getParameter("username");
        Connection con = null ;
        String std_id = request.getParameter("std_id");
        String pass = request.getParameter("pass");
        String address = request.getParameter("address");
        String email = request.getParameter("mail");
        String type = request.getParameter("type");
        PrintWriter out = response.getWriter();
        try 
        {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(name.length() == 0 || std_id.length() == 0 || pass.length() == 0 || address.length() == 0 || email.length() == 0 || type.length() == 0)
            {
                RequestDispatcher rd = request.getRequestDispatcher("register.html");
                rd.include(request, response);
                out.println("<font color = 'red'>Registration Unsucessful !! Please Try Agian</font>");
            }
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtp16kiit","root","password");
            PreparedStatement pst = con.prepareStatement("insert into login values(?,?,?)");
            con.setAutoCommit(false);
            pst.setString(1, std_id);
            pst.setString(2, pass);
            pst.setString(3, type);
            int status = pst.executeUpdate();
            pst = con.prepareStatement("insert into student_info values(?,?,?,?)");
            pst.setString(1, std_id);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, email);
            int status1 = pst.executeUpdate();
            if(status > 0 && status1 > 0)
            {
                con.commit();
                con.setAutoCommit(true);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
                out.println("Registration Sucessful");
            }
            else
            {
                con.rollback();
                con.setAutoCommit(true);
                RequestDispatcher rd = request.getRequestDispatcher("");
                rd.include(request, response);
                out.println("Registration Unsucessful");
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e)
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
            out.println("The login ID already exist.Please Try again with another ID");
        }
        catch(IOException | ClassNotFoundException | SQLException | ServletException e)
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
