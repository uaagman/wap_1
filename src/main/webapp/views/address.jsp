<%@ include file="inc/header.jsp" %>
<%@ include file="inc/head.jsp" %>

<div class="container">
<c:if test="${type eq 'billing'}">
	<label>Name<input type="text" name="name"></label>
</c:if>
	<label>City<input type="text" name="city"></label>
	<label>State<input type="text" name=state></label>
	<label>Street<input type="text" name="street"></label>
	<label>ZipCode<input type="text" name="zipCode"></label>
	<label>Phone<input type="text" name="phone"></label>
</div>
<%@ include file="inc/footer.jsp" %>