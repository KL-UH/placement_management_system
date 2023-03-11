package com.mvc.controller;
 
import java.io.IOException;

 
import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
 
    public LoginServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
 
        LoginBean loginBean = new LoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
        loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
        loginBean.setPassword(password);
 
        LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
        try
        {
        	String userValidate = loginDao.authenticateUser(loginBean);
        	if(userValidate.equals("Admin_Role"))
            {
                System.out.println("Admin's Home");
     
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", userName); //setting session attribute
                request.setAttribute("userName", userName);
     
                request.getRequestDispatcher("admin1.html").forward(request, response);
            }
            else if(userValidate.equals("Editor_Role"))
            {
                System.out.println("Editor's Home");
     
                HttpSession session = request.getSession();
                session.setAttribute("Editor", userName);
                request.setAttribute("userName", userName);
     
                request.getRequestDispatcher("hod.html").forward(request, response);
            }
            else if(userValidate.equals("User_Role"))
            {
                System.out.println("User's Home");
     
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("User", userName);
                request.setAttribute("userName", userName);
     
                request.getRequestDispatcher("student.html").forward(request, response);
            }
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);
     
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    } //End of doPost()
    }
        