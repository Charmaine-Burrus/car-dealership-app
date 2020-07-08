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

<!-- NavBar -->
<jsp:include page="customer_nav_bar.jsp"></jsp:include>

<!--- Two Column Section -->
<!-- this one will have text on left and image on right for large screens.. stacked for smaller ones -->
<div class="container-fluid padding">
	<div class="row padding">
		<!-- so this will only take up half the page in large, but full page with md or smaller. You only need to add the breakpoint for smaller than full-screen.. so don't need to include 12 here or anywhere-->
		<div class="col-md-12 col-lg-6 center text-center">
			<h2>Congratulations on your new vehicle!!</h2>
			<img class="center" src="img/Burrus automotive small.png"></a>
			<h4>${vehicle.year} ${vehicle.make} ${vehicle.model}</h4>
			<p>Price: $${vehicle.priceSold}</p>
			<p>Give us a call to schedule pickup of your vehicle at our nearest location.</p>
			<p>Please bring payment, Driver's License, and proof of insurance.</p>
			<p>Contact info & locations are listed at the bottom of this page.</p>	
		</div>
		<!-- see this is the same as the type above even though that specified 12 -->
		<div class="col-lg-6">
			<!-- fluid means it will be responsive and will move to take up it's whole div HOW COME IT HAS A BORDER?-->
			<img src="${vehicle.picURL}" class="img-fluid">
		</div>
	</div>
</div>

<!-- Footer -->
<jsp:include page="customer_footer.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script> <!--this allows us to use the social media links at bottom of page-->
</body>
</html>