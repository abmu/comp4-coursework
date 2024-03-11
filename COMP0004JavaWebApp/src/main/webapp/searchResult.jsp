<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base>
    <h1>Search Result</h1>
    <c:choose>
        <c:when test="${requestScope.result.size() > 0}">
            <ul>
                <c:forEach var="patient" items="${requestScope.result}">
                    <li>${patient}</li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>Nothing found</p>
        </c:otherwise>
    </c:choose>
</t:base>