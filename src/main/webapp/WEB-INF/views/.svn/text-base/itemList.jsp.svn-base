<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Mange Items"/>
<%@ include file="header.jsp" %>

		<script type="text/javascript" src="<c:url value='/scripts/lib/RowSelector.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/item.js' />"></script>

		<h1>Manage Items</h1>

		<form:form class="form-horizontal" name="addItem" action="" method="post" modelAttribute="item" onsubmit="return validateForm()">

            <div class="page-action">New Item</div>

            <div>
                <div class="control-group">
                    <form:label class="control-label" for="name" path="name">Name</form:label>
                    <div class="controls">
                        <form:input path="name" />
                        <c:if test="${not empty errors['name']}">
                            <span class="text-error">${errors['name']}</span>
                        </c:if>
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" for="price" path="price">Price</form:label>
                    <div class="controls">
                        <form:input path="price" />
                        <c:if test="${not empty errors['price']}">
                            <span class="text-error">${errors['price']}</span>
                        </c:if>
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" for="type" path="type">Type</form:label>
                    <div class="controls">
                        <form:select path="type">
                            <form:option value="" label="Select" />
                            <form:options items="${itemTypes}"/>
                        </form:select>
                        <c:if test="${not empty errors['type']}">
                            <span class="text-error">${errors['type']}</span>
                        </c:if>
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" for="desription" path="description">Description</form:label>
                    <div class="controls">
                        <form:textarea path="description" />
                        <c:if test="${not empty errors['description']}">
                            <span class="text-error">${errors['description']}</span>
                        </c:if>
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" for="quantity" path="quantity">Quantity</form:label>
                    <div class="controls">
                        <form:input path="quantity" />
                        <c:if test="${not empty errors['quantity']}">
                            <span class="text-error">${errors['quantity']}</span>
                        </c:if>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <button type="submit" value="Create new item" id="createItem" class="btn btn-warning">Create Item</button>
                    </div>
                </div>

                </div>
		</form:form>

		<form:form action="" method="post" modelAttribute="itemGrid">

            <div class="page-action">Update Items</div>

            <div>
			    <table class="table">
				<thead><tr><th><input type="checkbox" class="toggleAll" /></th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>ItemType</th>
				<th>Quantity</th>
				</tr></thead>
				<tbody>
					<c:forEach var="itemEntry" items="${itemGrid.itemMap}" varStatus="row">
						<tr>
							<td>
								<form:input type="hidden" disabled="true" path="itemMap[${itemEntry.key}].itemId" />
								<input type="checkbox" class="rowSelector" />
							</td>
							<td>
								<form:errors path="itemMap[${itemEntry.key}].name" cssClass="text-error" />
								<form:input disabled="true" path="itemMap[${itemEntry.key}].name" />
							</td>
							<td>
								<form:errors path="itemMap[${itemEntry.key}].price" cssClass="text-error" />
								<form:input class="input-small" disabled="true" path="itemMap[${itemEntry.key}].price" />
							</td>
							<td>
								<form:errors path="itemMap[${itemEntry.key}].description" cssClass="text-error" />
								<form:input path="itemMap[${itemEntry.key}].description" disabled="true"/>
							</td>
							<td>
                            	<form:errors path="itemMap[${itemEntry.key}].type" cssClass="text-error" />
       							<form:input path="itemMap[${itemEntry.key}].type" disabled="true" />
     					    </td>
     					    <td>
                                <form:errors path="itemMap[${itemEntry.key}].quantity" cssClass="text-error" />
                                <form:input class="input-small" path="itemMap[${itemEntry.key}].quantity" disabled="true" />
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			    </table>

			<p>
                <button type="submit" value="Update all enabled items" name="update" class="btn btn-warning">Update all enabled items</button>
                <button type="submit" value="Delete all enabled items" name="delete" class="btn btn-danger">Delete all enabled items</button>
			</p>

            </div>
		</form:form>
<%@ include file="footer.jsp" %>
