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

<!-- NavBar -->
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

<!-- Selection Area -->
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

<!-- Footer -->
<jsp:include page="customer_footer.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>