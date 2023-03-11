<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN PAGE</title>
</head>
<body>
<center>
<table border="1">
<tr style="background-color:#024273;color:white">
	<td>Company</td>
	<td>Role</td>
	<td>Duration</td>
	<td>Stipend</td>
	<td>Location</td>
	<td>Link</td>
</tr>
<%
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Mounika.1025");
Statement statement = connection.createStatement() ;
// String company = request.getParameter("Company");
ResultSet resultset = statement.executeQuery("select * from internship");

%>

<% while(resultset.next()){ %>
		
		

			<tr>
				<td><%= resultset.getString("Company") %></td>
	            <td><%= resultset.getString("Role") %></td>
				<td><%= resultset.getString("Duration") %></td>
	            <td><%= resultset.getString("Stipend") %></td>
	            <td><%= resultset.getString("Location") %></td>
	            <td><a href="<%= resultset.getString("Link") %>">Click me</a></td>
            </tr>
        	
        
           <% } %>
 </table>
</center>
</body>
</html>