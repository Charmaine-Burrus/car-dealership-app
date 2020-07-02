<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Search by Model</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href="./styles/styles.css" rel="stylesheet">
</head>

<body>

<jsp:include page="customer_nav_bar.jsp"></jsp:include>

<!--- Header -->
<div class="container-fluid padding">
<div class="row welcome text-center">
	<div class="col-12">
		<h1 class="display-4">Search for the Perfect Vehicle</h1>
	</div>
	<hr>
</div>
</div>

<!-- Selection Area to do: put new/used first and then display models based on that, JSTL can i put make first and narrow model choices by that?, can I use this with a checkbox select(and read it in as an array of Models?)
TO DO: Modify formatting... don't still admin-login and form-sign-in.-->
<div class="container-fluid admin-login">
	<form class="form-signin" action="SearchServlet" method="post">    
	    <div>
	    	Model
	    	<select class="form-control" name="model" id="model">
	    	<c:forEach var="model" items="${dealership.getAllModels()}">
		      <option value="${model}">${model}</option>
		    </c:forEach>
		    </select>
	    </div>
	    <div class="selector">
		  <input type="checkbox" name="includeNew" value="true" id="includeNew" />
		  <label for="includeNew">New</label>
		  <input type="checkbox" name="includeUsed" value="true" id="includeUsed" />
		  <label for="includeUsed">Used</label>
		</div>
		<div>
		  <button type="submit" class="btn btn-primary mt-2">Search</button>
		</div>
	</form>
</div>

<!--- Cards -->
<div class="container-fluid padding">
<div class="row padding">
	<c:if test="${vehiclesFromSearch.isEmpty()}">
		<div class="alert alert-info" role="alert">
  			No vehicles were found that match these criteria. Feel free to try another search.
		</div>
	</c:if>
	<c:forEach var="vehicle" items="${vehiclesFromSearch}">
		<!--card 1-->
		<div class="col-md-4">
			<div class="card">
				<img class="card-img-top inv-pics" src="${vehicle.picURL}">
				<div class="card-body">
					<h4 class="card-title">${vehicle.year} ${vehicle.make} ${vehicle.model}</h4>
					<p class="card-text">Price: $${vehicle.askingPrice}</p>
					<p class="card-text">Description: ${vehicle.description}</p>
					<c:if test="${vehicle.isEligibleForBid() == true}">
						<form action="AddVehicleToSessionServlet" method="post">
							<button type="submit" class="btn btn-outline-secondary" name="vehicleId" value="${vehicle.id}">Place a Bid</button>
						</form>
					</c:if>
				</div>
			</div>
		</div>	
	</c:forEach>
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