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

<!--- Header -->
<div class="container-fluid padding">
<div class="row welcome text-center">
	<div class="col-12">
		<h1 class="display-4">The Best Selection of Pre-Owned Vehicles</h1>
	</div>
	<hr>
</div>
</div>

<!--- Cards -->
<div class="container-fluid padding">
<div class="row padding">
	<c:forEach var="vehicle" items="${dealership.usedInventory}">
		<!--card 1-->
		<div class="col-md-4">
			<div class="card">
				<img class="card-img-top inv-pics" src="${vehicle.picURL}">
				<div class="card-body">
					<h4 class="card-title">${vehicle.year} ${vehicle.make} ${vehicle.model}</h4>
					<p class="card-text">Price: $${vehicle.askingPrice}</p>
					<p class="card-text">Mileage: ${vehicle.miles} miles. Condition: ${vehicle.kbbCondition}</p>
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