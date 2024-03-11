<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base>
    <ul>
        <c:forEach var="data" items="${requestScope.patientRecord}">
            <li>
                <p>${data.key}: ${data.value}</p>
            </li>
        </c:forEach>
    </ul>
</t:base>