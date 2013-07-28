<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageTitle" scope="request" value="Create Account"/>

<%@ include file="../header.jsp" %>

<div id="resultMessage" class="page-action">
    Hello, ${postedValues.name}, your new account has been created!
</div>

<%@ include file="../footer.jsp" %>
