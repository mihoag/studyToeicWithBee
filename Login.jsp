<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form | CoderGirl</title>
  <!---Custom CSS File--->
  <link rel="stylesheet" href="style.css">
  
</head>
<body>
    <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Login</header>
      <%=request.getAttribute("msg") != null? request.getAttribute("msg") : "" %>
      <form action="LoginController" method="POST">
        <input type="text" name = "username" placeholder="Enter your username">
        <input type="password" name = "password" placeholder="Enter your password">
        <a href="#">Forgot password?</a>
        <input type="submit" class="button" value="Login">
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
         <a href="SignUp.jsp">Signup</a>
        </span>
      </div>
    </div>
   
  </div>
</body>
</html>
