<%@ include file="inc/header.jsp" %>
<%@ include file="inc/head.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <form action="<c:url value="checkout"/> " method="post">
            <c:choose>
                <c:when test="${addType eq 'shipping'}">
                    <h3> Enter Shipping Address </h3>
                    <div class="form-group">
                        <label for="name" class="label">Full Name</label>
                        <input type="text" name="name" id="name" class="form-control"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <h3> Enter Billing Address </h3>
                </c:otherwise>
            </c:choose>
            <div class="form-group">
                <label for="city" class="label">City</label>
                <input type="text" name="city" id="city" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="state" class="label">State</label>
                <input type="text" name="state" id="state" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="street" class="label">Street</label>
                <input type="text" name="street" id="street" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="zip" class="label">ZipCode</label>
                <input type="text" name="zip" id="zip" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="phone" class="label">Phone</label>
                <input type="text" name="phone" id="phone" class="form-control"/>
            </div>
            <input type="hidden" name="addType" value="${addType}">
            <button type="submit" class="btn btn-primary">Add Address</button>
        </form>
    </div>
    </div>
</div>
<%@ include file="inc/footer.jsp" %>