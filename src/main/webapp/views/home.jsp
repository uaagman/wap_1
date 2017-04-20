<%@ include file="inc/header.jsp"%>
<%@ include file="inc/head.jsp"%>

<div class="container">
	<div class="row">
		<h1>Home Page</h1>
	</div>
	<div id="product-list">
		<c:forEach items="${products}" var="product">
			<div class="item">
				<c:if test="${product!=null}">
					<form action='<c:url value="myCart"/>' method="post">
						<img src="${product.image}" alt="" />
						<div class="row">
							<div class="col-md-7 col-sm-7">
								<div class="name">${product.name}</div>
								<div class="price">${product.price}</div>
								<div class="description">${product.description}</div>
								<button class="btn btn-primary btn-md">Add to Cart</button>
							</div>
							<div class="col-md-5 col-sm-5">
								Quantity: <input class="form-control" type="text" name="qty">
								<input type="hidden" name="pro_id" value="${product.id}">
							</div>
						</div>
					</form>
				</c:if>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="inc/footer.jsp"%>