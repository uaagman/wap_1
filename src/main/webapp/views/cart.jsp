<%@ include file="inc/header.jsp" %>
<%@ include file="inc/head.jsp" %>

<div class="container">
    <h3 class="has-error">${error}</h3>
    <div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Item</th>
                    <th>Per Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            <c:set var="count" value="0" scope="page" />
            <c:set var="total" value="0" scope="page" />
            <c:if test="${cartItems != null}">
                <c:forEach items="${cartItems}" var="item">
                    <tr>
                        <td><c:out value="${count}"/></td>
                        <td><c:out value="${item.product.name}"/></td>
                        <td><c:out value="${item.product.price}"/></td>
                        <td><c:out value="${item.qty}"/></td>
                        <td><c:out value="${item.qty * item.product.price}"/></td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <c:set var="total" value="${total + (item.qty * item.product.price)}" scope="page"/>
                </c:forEach>
                <tr><td></td><td colspan="3">Total:</td><td>${total}</td></tr>
                <tr><td colspan="4"></td><td><a href="<c:url value="checkout"/>" class="btn btn-primary">Checkout</a></td></tr>
            </c:if>
            </tbody>
        </table><br/><hr/>
        <a href="<c:url value="home"/>" class="btn btn-info pull-right">Continue Shopping</a>
    </div>
</div>

<%@ include file="inc/footer.jsp" %>