<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.claim.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href="./styles/styles.css" rel="stylesheet">
</head>

<body class="text-center admin-login">
		
	<form class="form-signin" action="AdminLoginServlet" method="post">
  	  <img class="mb-4 center" src="img/Burrus automotive - medium.png">
  	  <h1 class="h3 mb-3 font-weight-normal">Admin Login</h1>
  	  <c:if test="${loginSuccessful == false}">
      	<div class="alert alert-danger" role="alert">
  			Login Unsuccessful. Please check your ID & Password.
		</div>
	  </c:if>
	  <input type="text" id="employeeId" class="form-control mb-2" name="employeeId" placeholder="Employee ID #" required="" autofocus="">
	  <input type="password" id="inputPassword" class="form-control mb-2" name="password" placeholder="Password" required="">
	  <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">Log in</button>
	</form>
			
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script> <!--this allows us to use the social media links at bottom of page-->
</body>
</html>