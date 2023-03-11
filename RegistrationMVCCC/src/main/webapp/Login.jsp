<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
    overflow: hidden;
    background-color: black;
    height:80px;
}
.topnav a {
  float: right;
  color: #f2f2f2;
  text-align: center;
  padding: 30px 26px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
table {
  width: 800px;
  padding: 60px;

  margin: 0;
  margin-left:auto;
  margin-right:auto;
}
.container {
  display: flex;
  align-items: center;
  justify-content: center
}

img {
  width: 100%;
  height: 900px
}

.image {
  flex-basis: 50%
}

.text {
   width: 300px; 

   padding: 40px; 

   position: absolute; 

   top: 65%; 

   left: 50%; 

   transform: translate(-50%,-50%); 

   background: #C0C0C0; 

   text-align: center; 

   border-radius: 70px; 

   user-select: none; 
}
.text h1{ 

   color: white; 

   text-transform: uppercase; 

   font-weight: 500; 

 }
 .text h1:hover{color:#2ecc71}  
 .text input[type = "text"], .text input[type = "password"]{ 

   border:0; 

   background: none; 

   display: block; 

   margin: 20px auto; 

   text-align: center; 

   border: 2px solid #3498db; 

   padding: 15px 1px; 

   width: 200px; 

   outline: none; 

   color: #3498db; 

   border-radius: 24px; 

   transition: 0.25s 

 } 

  

 .text input::placeholder{color: #3498db88} 

 .text input[type = "text"]:focus,.text input[type = "password"]:focus{ 

   width: 280px; 

   border-color: #2ecc71 

 } 

  

 .text input[type = "submit"]{ 

   border:0; 

   background: none; 

   display: block; 

   margin: 20px auto; 


   border: 2px solid #2ecc71; 

   padding: 14px 40px; 

   outline: none; 

   color: #2ecc71; 

   border-radius: 24px; 

   transition: 0.25s; 

   cursor: pointer 

 } 
.text input[type = "reset"]{ 

   border:0; 

   background: none; 

   display: block; 

   margin: 20px auto; 



   border: 2px solid #2ecc71; 

   padding: 14px 40px; 

   outline: none; 

   color: #2ecc71; 

   border-radius: 24px; 

   transition: 0.25s; 

   cursor: pointer 

 } 

   .text input[type = "reset"]:hover{ 

   background: #2ecc71; 

   color: white 

 }

 .text input[type = "submit"]:hover{ 

   background: #2ecc71; 

   color: white 

 }
 
td{
  font-size: 30px;
}
input{
  font-size: 20px;
}
.topnav img {
  float: left;
  width: 150px;
  height: 100px;
  background: #555;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script> 
function validate()
{ 
     var username = document.form.username.value; 
     var password = document.form.password.value;
 
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
}
</script> 
</head>
<body style="background-color:#024273;">
<div class="topnav">
  <a href="contact.jsp">Contact</a>
  <a href="about.jsp">About</a>
  <img src="image.png" alt="logo" />
</div>
    <div style="text-align:center" ><h1><i>KL UNIVERSITY PLACEMENT SYSTEM </i></h1> </div>
    <br>
    <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
        <!-- Do not use table to format fields. As a good practice use CSS -->
        <div class="container">


      <h1>Login</h1> 
        <table class="text" >
         <tr>
         <td><b>Username</b></td>
         <td><input type="text" name="username"/></td>
         </tr>
         <tr>
         <td><b>Password</b></td>
         <td><input type="password" name="password"/></td>
         </tr>
         <tr> <!-- refer to the video to understand request.getAttribute() -->
         <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Login"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
  
    </div>
    </form>
    
</body>
</html>