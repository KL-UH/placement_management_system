<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <script src="https://kit.fontawesome.com/5b61822651.js" crossorigin="anonymous"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400&display=swap" rel="stylesheet">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Navbar</title>
  <link rel="stylesheet" href="admin.css">
</head>

<body style="background-color:#024273;">
      <div class ="t">
         <form class = 'y'  action="Mocktests" method="post"> 
         
            <label for="Course_name">Course_name</label>
            <input type="text"  id="Course_name" name="Course_name"><br><br>

            <label for="Enter_test_URL">Enter_test_URL</label>
            <input type="text" id="Enter_test_URL" name="Enter_test_URL"><br><br>
          <input class="f" type="submit" value="Submit"/>
          
           </form>
           
          <button class="view" type="button" onclick="location.href = 'questions.jsp';">View Mocktests</button><br>
        
      </div>
    


     
   </body>


</html>