<%@ include file="inc/header.jsp"%>
<title>Login</title>
</home>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="form-login">
					<form action="<c:url value='/login'/>" method="post">
						<h4>Welcome</h4>
						<h6>${error}</h6>
						<div class="form-group">
							<label class="sr-only" for="userName">Username</label> <input
								type="text" id="userName" name="userName"
								class="form-control input-sm chat-input" placeholder="username"
								required="required" value="${user}" />
						</div>
						<div class="form-group">
							<label class="sr-only" for="userName">Username</label> <input
								type="password" id="userPassword" name="userPassword"
								class="form-control input-sm chat-input" placeholder="password"
								required="required" />
						</div>
						<div class="checkbox">
							<label> <input type="checkbox" name="remember" ${check}>
								Remember Me
							</label>
						</div>
						<div class="wrapper">
							<span class="group-btn">
								<button type="submit" class="btn btn-primary btn-md">
									login <i class="fa fa-sign-in"></i>
								</button>
							</span>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<%@ include file="inc/footer.jsp"%>