<%@ include file="inc/header.jsp" %>
<%@ include file="inc/head.jsp" %>

<div class="container">
    <h3 class="text-danger">${error}</h3>
    <h3 class="text-info">Congratulations, your order has been confirmed. <br/><small>Your Order Details are : </small></h3>
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
            </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="inc/footer.jsp"%>