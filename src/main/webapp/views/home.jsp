<%@ include file="inc/header.jsp" %>
<%@ include file="inc/head.jsp" %>

<div class="container">
    <div class="row">
       <h1>Home Page</h1>
    </div>
    <div id="list">
	    <c:forEach items="products" var="product">
	    <div class="item">
	    	<img src="${product.image}" alt=""/>
	    	<div class="name">${product.name}</div>
	    	<div class="price">${product.price}</div>
	    	<div class="description">${product.description}</div>
	    </div>
	    </c:forEach>    
    </div>
</div>

<%@ include file="inc/footer.jsp" %>