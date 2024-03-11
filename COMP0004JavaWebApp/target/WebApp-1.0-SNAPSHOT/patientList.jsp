<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Patient list">
    <h2>Patients:</h2>
    <ul>
        <c:forEach var="patient" items="${requestScope.patientIds}">
            <li>
                <a href="patients/${patient}">${patient}</a>
            </li>
        </c:forEach>
    </ul>
</t:base>