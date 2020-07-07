<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.claim.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Burrus Automotive</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href="./styles/styles.css" rel="stylesheet">
	<!-- initializing some stuff when the page loads	-->
	<% Dealership dealership = new Dealership(); %>
	<% dealership.readInventoriesFromFile(); %>
	<% session.setAttribute("dealership", dealership); %>
</head>

<body>

<jsp:include page="customer_nav_bar.jsp"></jsp:include>

<!--- Welcome Section -->
<!-- padding adds space b/t the container and rows. welcome is the class we use to style this -->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="display-4">Burrus Automotive</h1>
		</div>
		<hr>
		<div class="col-12">
			<p class="lead">The region's go-to for all your automotive needs.</p>
		</div>
	</div>
</div>

<!--- Header for Cards-->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="display-4">View Our Extensive Inventory</h1>
		</div>
	<hr>
</div>
</div>

<!--- Cards -->
<!--card 1: New -->
<div class="container-fluid padding">
<div class="row padding">
	<!--card 1-->
	<div class="col-md-4">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top home-pics" src="img/new vehicles.jpg">
			<div class="card-body">
				<h4 class="card-title">New Vehicles</h4>
				<p class="card-text">Be the envy of the neighborhood!</p>
				<a href="new_inventory.jsp" class="btn btn-outline-secondary">View New Vehicles</a>
			</div>
		</div>
	</div>	

	<!--card 2: Used -->
	<div class="col-md-4">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top home-pics" src="img/used vehicles.jpg">
			<div class="card-body">
				<h4 class="card-title">Used Vehicles</h4>
				<p class="card-text">Check out our dependable pre-owned models.</p>
				<a href="used_inventory.jsp" class="btn btn-outline-secondary align-self-end">View Used Vehicles</a>
			</div>
		</div>
	</div>	

	<!--card 3: Best Deals -->
	<div class="col-md-4">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top home-pics" src="img/deals.jpg">
			<div class="card-body">
				<h4 class="card-title">Best Deals</h4>
				<p class="card-text">These vehicles have been on our lot for 120 days or more and are offered for bid at a special discount price.</p>
				<a href="best_deals.jsp" class="btn btn-outline-secondary align-self-end">View the Deals</a>
			</div>
		</div>
	</div>	
	
	<!--card 4: Search -->
	<div class="col-md-4 center">
		<div class="card">
			<!--img will be at the top of the card, not bottom or mid-->
			<img class="card-img-top home-pics" src="img/search.jpg">
			<div class="card-body">
				<h4 class="card-title">Search for a Specific Model</h4>
				<p class="card-text">We can help you on your quest for the perfect vehicle.</p>
				<a href="search.jsp" class="btn btn-outline-secondary align-self-end">Search</a>
			</div>
		</div>
	</div>	
</div>
</div>

<!--- Connect on Social Media -->
<div class="container-fluid padding">
<div class="row text-center padding">
	<div class="col-12">
		<h2>Connect</h2>
	</div>
	<!-- padding to separate the icons from the heading, and a social class styled in css -->
	<div class="col-12 social padding">
		<!--below we have font-awesome references again -->
		<a href="#"><i class="fab fa-facebook"></i></a>
		<a href="#"><i class="fab fa-twitter"></i></a>
		<a href="#"><i class="fab fa-instagram"></i></a>
	</div>
</div>
</div>


<!--- Footer -->
<jsp:include page="customer_footer.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script> <!--this allows for the social media links at bottom of page-->
</body>
</html>