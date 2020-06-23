<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Burrus Automotive</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href="./styles/styles.css" rel="stylesheet">
	<!-- 	<link rel="stylesheet" href="https://m.w3newbie.com/you-tube.css"> -->
</head>
<body>

<!-- Navigation -->
<!-- navbar is styled in CSS to have more padding -->
<!--md is the breakpoint where it will expand from mobile to regular -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top"> 
<!--container fluid takes up 100% of the screen-->
<div class="container-fluid">
	<!-- adding a logo at the top.. with href="#" just takes you to the top of the current page.. can be used as a place saver ... notice the nav bar expands to hold the image-->
	<a class="navbar-brand" href="#"><img src="img/Burrus automotive small.png"></a>
	<!-- this starts our navbar dropdown/toggler -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"> 
		<!-- this gives an icon which makes the navbar-toggler look way cooler AT THIS POINT HIS IS SHOWING A WHOLE DROP-DOWN-->
		<span class="navbar-toggler-icon"> </span>
	</button>
	<!-- notice that the button above references the id of this collapsable nav bar which is why it's what pops up when you hit the button -->
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<!-- ml-auto pushes the navigation to the right-hand side(instead of the middle) -->
		<!-- this gives us all our links in navbar navbar-nav is in CSS-->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="#">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Admin Login</a>
			</li>
		</ul>
	</div>
</div>
</nav>	

<!--- Welcome Section to do: make this look better... maybe add caroseul with current staff pics-->
<!-- padding adds space b/t the container and rows.. welcome is a class we'll make to style this -->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="display-4">Burrus Automotive</h1>
		</div>
		<!--used to separate content -->
		<hr>
		<div class="col-12">
			<p class="lead">The region's go-to for all your automotive needs.</p>
		</div>
	</div>
</div>

<!--- Header -->
<div class="container-fluid padding">
<div class="row welcome text-center">
	<div class="col-12">
		<h1 class="display-4">View Our Extensive Inventory</h1>
	</div>
	<!--to do: why isn't this working? Horizontal rule to separate title from cards-->
	<hr>
</div>
</div>

<!--- Cards -->
<div class="container-fluid padding">
<div class="row padding">
	<!--card 1-->
	<div class="col-md-4">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top inv-pics" src="img/new vehicles.jpg">
			<div class="card-body">
				<h4 class="card-title">New Vehicles</h4>
				<p class="card-text">Brand new cars. Yay!</p>
				<a href="#" class="btn btn-outline-secondary" action="SchedulerServlet" method="post" type="submit">View New Vehicles</a>
			</div>
		</div>
	</div>	

	<!--card 2-->
	<div class="col-md-4">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top inv-pics" src="img/used vehicles.jpg">
			<div class="card-body">
				<h4 class="card-title">Used Vehicles</h4>
				<p class="card-text">Choose from our pre-owned models.</p>
				<a href="#" class="btn btn-outline-secondary">View Used Vehicles</a>
			</div>
		</div>
	</div>	

	<!--card 3-->
	<div class="col-md-4">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top inv-pics" src="img/deals.jpg">
			<div class="card-body">
				<h4 class="card-title">Best Deals</h4>
				<p class="card-text">These vehicles have been on our lot for 120 days or more and are offered for bid at a special discount price.</p>
				<a href="#" class="btn btn-outline-secondary">View the Deals</a>
			</div>
		</div>
	</div>	
</div>
</div>

<!--- Connect -->
<div class="container-fluid padding">
<div class="row text-center padding">
	<div class="col-12">
		<h2>Connect</h2>
	</div>
	<!-- we wanting padding to separate the icons from the heading, and we also have a social class that we'll style later -->
	<div class="col-12 social padding">
		<!--below we have font-awesome references again -->
		<a href="#"><i class="fab fa-facebook"></i></a>
		<a href="#"><i class="fab fa-twitter"></i></a>
		<a href="#"><i class="fab fa-instagram"></i></a>
	</div>
</div>
</div>


<!--- Footer -->
<footer>
<div class="container-fluid padding">
<div class="row text-center">
	<div class="col-md-4">
		<hr class="light">
		<h5>Contact Us</h5>
		<hr class="light">
		<p>555-555-5555</p>
		<p>burrus@burrus-auto.com</p>
		<p>100 Easy St.</p>
		<p>St. Louis, MO, 00000</p>
	</div>
	<div class="col-md-4">
		<hr class="light">
		<h5>Our hours</h5>
		<hr class="light">
		<p>Monday-Friday: 9am - 5pm</p>
		<p>Saturday: 9am - 4pm</p>
		<p>Sunday: 12pm - 4pm</p>
	</div>
	<div class="col-md-4">
		<hr class="light">
		<h5>Service Areas</h5>
		<hr class="light">
		<p>St. Louis, MO, 00000</p>
		<p>O'Fallon, MO, 00000</p>
		<p>O'Fallon, IL, 00000</p>
		<p>Alton, IL, 00000</p>
	</div>
	<!--socket section or section under the footer-->
	<div class="col-12">
		<hr class="light">
		<!-- &copy is a copyright symbol -->
		<h5>&copy; burrus-auto.com</h5>
	</div>
</div>
</div>
</footer>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script> <!--this allows us to use the social media links at bottom of page-->
</body>
</html>