<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Search">
    <h2>Search</h2>
    <form method="POST" action="${pageContext.request.contextPath}/search">
        <select name="columnname">
            <option value="ID">ID</option>
            <option value="FIRST">First name</option>
            <option value="LAST">Last name</option>
            <option value="ZIP">ZIP code</option>
        </select>
        <input type="text" name="searchstring" placeholder="Enter search keyword here" value="${requestScope.searchString}"/>
        <input type="submit" value="Search"/>
    </form>
    <c:if test="${requestScope.result != null}">
        <c:choose>
            <c:when test="${requestScope.result.size() > 0}">
                <p>${requestScope.result.size()} results found</p>
                <ul>
                    <c:forEach var="patient" items="${requestScope.result}">
                        <li>
                            <a href="patients/${patient}">${patient}</a>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p>Nothing found</p>
            </c:otherwise>
        </c:choose>
    </c:if>
</t:base>