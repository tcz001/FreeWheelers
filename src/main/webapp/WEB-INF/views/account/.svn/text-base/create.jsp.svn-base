<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageTitle" scope="request" value="Create Account"/>

<%@ include file="../header.jsp" %>

    <div class="page-action">
        Create a new account
    </div>

    <c:if test="${not empty validationMessage.errors}">
        <div id="resultsMessage" class="page-action error">
            There were errors.
        </div>
    </c:if>

	<form class="form-horizontal" action="/account/create" method="post">
        <div class="control-group">
            <label class="control-label" for="fld_email">Email</label>
            <div class="controls">
                <input type="text" id="fld_email" placeholder="somebody@something.com" name="email">
                <c:if test="${not empty validationMessage.errors['email']}">
                    <span class="text-error">${validationMessage.errors["email"]}</span>
                </c:if>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="fld_password">Password</label>
            <div class="controls">
                <input type="text" id="fld_password" placeholder="secret password" name="password">
                <c:if test="${not empty validationMessage.errors['password']}">
                    <span class="text-error">${validationMessage.errors["password"]}</span>
                </c:if>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="fld_name">Name</label>
            <div class="controls">
                <input type="text" id="fld_name" placeholder="Your Name" name="name">
                <c:if test="${not empty validationMessage.errors['name']}">
                    <span class="text-error">${validationMessage.errors["name"]}</span>
                </c:if>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="fld_phoneNumber">Phone Number</label>
            <div class="controls">
                <input type="text" id="fld_phoneNumber" placeholder="555-123456" name="phoneNumber">
                <c:if test="${not empty validationMessage.errors['phoneNumber']}">
                    <span class="text-error">${validationMessage.errors["phoneNumber"]}</span>
                </c:if>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button type="submit" id="createAccount" value="Submit" class="btn btn-success">Create Account</button>
            </div>
        </div>

	</form>

<%@ include file="../footer.jsp" %>
