<!-- Navigation -->
<!-- navbar is styled in CSS to have more padding -->
<!--md is the breakpoint where it will expand from mobile to regular -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top"> 
<!--container fluid takes up 100% of the screen-->
<div class="container-fluid">
	<!-- logo at the top always links to home-->
	<a class="navbar-brand" href="index.jsp"><img src="img/Burrus automotive small.png"></a>
	<!-- this starts our navbar dropdown/toggler -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"> 
		<!-- this gives an icon which makes the navbar-toggler look way cooler-->
		<span class="navbar-toggler-icon"> </span>
	</button>
	<!-- notice that the button above references the id of this collapsable nav bar (so it pops up when you hit the button) -->
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<!-- ml-auto pushes the navigation to the right-hand side(instead of the middle) -->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="new_inventory.jsp">New Inventory</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="used_inventory.jsp">Used Inventory</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="best_deals.jsp">Best Deals</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="search.jsp">Search</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="admin_login.jsp">Admin Login</a>
			</li>
		</ul>
	</div>
</div>
</nav>