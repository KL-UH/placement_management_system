package servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      String Name = request.getParameter("Name");
      String Email = request.getParameter("Email");
      String Phone = request.getParameter("Phone");
      String Graduation = request.getParameter("Graduation");
      String CGPA = request.getParameter("CGPA"); 
   

      
      try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Mounika.1025"); 
        String s = ("insert into student_info values (?,?,?,?,?)"); 
        PreparedStatement p = con.prepareStatement(s); 
        p.setString(1,Name);
        p.setString(2,Email );
        p.setString(3,Phone);
        p.setString(4,Graduation);
        p.setString(5,CGPA);
        int i = p.executeUpdate();
        if (i>0) {
          response.sendRedirect("student.html"); 
        }
        
      } catch (ClassNotFoundException | SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } 
        out.close();
        doGet(request, response);
      }

    }