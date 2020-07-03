<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Used Inventory</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href="./styles/styles.css" rel="stylesheet">
</head>

<body>

<jsp:include page="customer_nav_bar.jsp"></jsp:include>

<!--- Two Column Section -->
<!-- this one will have text on left and image on right for large screens.. stacked for smaller ones -->
<div class="container-fluid padding">
	<div class="row padding">
		<!-- so this will only take up half the page in large, but full page with md or smaller. You only need to add the breakpoint for smaller than full-screen.. so don't need to include 12 here or anywhere-->
		<div class="col-md-12 col-lg-6 center">
			<h2>${vehicle.year} ${vehicle.make} ${vehicle.model}</h2>
			<p>Price: $${vehicle.askingPrice}</p>
			<p>Description: ${vehicle.description}</p>
			<!-- break before the button -->
			<br>
			
			<form action="PlaceBidServlet" method="post">
				
				<div class="form-row mb-2">
                        <div class="col">
                            <input type="text" class="form-control" name="firstName" placeholder="First Name" required/>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name="lastName" placeholder="Last Name" required/>
                        </div>
                </div>
				
				<div class="form-row mb-2">
                        <div class="col">
                            <input type="text" class="form-control" name="email" placeholder="Email Address" required/>
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name="phone" placeholder="Phone Number" required/>
                        </div>
                </div>
                
                <c:if test="${bidSuccessful == false}">
                	<div class="alert alert-danger" role="alert">
  						Offer was too low! Offer must be at least 90% of asking price.
					</div>
				</c:if>
                
                <div class="form-row mb-2">
                        <div class="col">
                            Offer*<span> <input type="text" class="form-control" name="offeredPrice" placeholder="${vehicle.askingPrice}" required/> </span>
                            *Offer must be at least 90% of asking price.
                        </div>
                </div>
				
				<div>
					<button type="submit" class="btn btn-primary mt-2">Submit Bid</button>
				</div>
				
			</form>
			
		</div>
		<!-- see this is the same as the type above even though that specified 12 -->
		<div class="col-lg-6">
			<!-- fluid means it will be responsive and will move to take up it's whole div HOW COME IT HAS A BORDER?-->
			<img src="${vehicle.picURL}" class="img-fluid">
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