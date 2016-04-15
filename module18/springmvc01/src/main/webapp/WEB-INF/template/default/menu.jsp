<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
Menu
    <ul>
        <li>
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>
        <li>
            <spring:url value="/new" var="newUrl" htmlEscape="true"/>
            <a href="${newUrl}">New</a>
        </li>
    </ul>
</div>