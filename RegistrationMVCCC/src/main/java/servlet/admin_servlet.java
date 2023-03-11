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

public class admin_servlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public admin_servlet() {
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
	      
	      String Company = request.getParameter("Company");
	      String Role = request.getParameter("Role");
	      String Experience = request.getParameter("Experience");
	      String Salary = request.getParameter("Salary");
	      String Location = request.getParameter("Location");
	      String Link = request.getParameter("Link");
	      
	      try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Mounika.1025"); 
	        String s = ("insert into admin values (?,?,?,?,?,?)"); 
	        PreparedStatement p = con.prepareStatement(s); 
	        p.setString(1,Company);
	        p.setString(2,Role);
	        p.setString(3,Experience);
	        p.setString(4,Salary);
	        p.setString(5,Location);
	        p.setString(6,Link);

	        int i = p.executeUpdate();
	        if (i>0) {
	          response.sendRedirect("admin1.html"); 
	        }
	        
	      } catch (ClassNotFoundException | SQLException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        } 
	        out.close();
	        doGet(request, response);
	      }

	    }