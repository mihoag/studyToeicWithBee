<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="style.css">
<title>Sign Up</title>
<script type="text/javascript">
       function validate() {
    	   var name = document.myform.name.value;
		   var membername = document.myform.username.value;
		   var memberpass = document.myform.password.value;
		   
		   if (name == "" || membername == "" || memberpass == "")
			{
				alert("Yêu cầu không bỏ trống bất kì thông tin nào");
				return false;
				
			}
	}
</script>
</head>
<body>
     <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Sign Up</header>
      <%=request.getAttribute("msg") != null? request.getAttribute("msg") : "" %>
      <form name = "myform" action = "SignUpController" method = "POST" onsubmit="return validate()">
        <input type="text" name = "name" placeholder="Enter your name">
        <input type="text" name = "username" placeholder="Enter your username">
        <input type ="password" name = "password" placeholder="Enter your password">
  
        <input type="submit" class="button" value="Sign up">
      </form>
      <div class="signup">
        <span class="signup">You have already had an account?
         <a href="Login.jsp">Login</a>
        </span>
      </div>
    </div>
   
  </div>
</body>
</html>