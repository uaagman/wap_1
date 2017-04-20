
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">webStore</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/"/> ">Home</a></li>
				<li><a href="javascript:;">Products</a></li>
				<li><a href="<c:url value="myCart"/> ">Cart</a></li>
				<c:choose>
					<c:when test="${LoggedUser eq null}">
						<li><a href="<c:url value="login"/>">Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value="logout"/>">(${LoggedUser})Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>