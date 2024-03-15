<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Patient list">
    <h1>Patients</h1>
    <form method="POST" action="${pageContext.request.contextPath}/patients">
        <div class="input-group mb-2">
            <button class="btn btn-info" type="submit">Save to JSON</button>
        </div>
    </form>
    <ul>
        <c:forEach var="patient" items="${requestScope.patientIds}">
            <li>
                <a href="patients/${patient}">${patient}</a>
            </li>
        </c:forEach>
    </ul>
</t:base>