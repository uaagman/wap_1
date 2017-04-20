<%@ include file="inc/header.jsp" %>
<%@ include file="inc/head.jsp" %>

<div class="container">
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
                <c:forEach items="cartItems" var="item">
                    <tr>
                        <td><c:out value="${count}"/></td>
                        <td><c:out value="${item.name}"/></td>
                        <td><c:out value="${item.price}"/></td>
                        <td><c:out value="${item.qty}"/></td>
                        <td><c:out value="${item.qty * item.price}"/></td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="inc/footer.jsp" %>