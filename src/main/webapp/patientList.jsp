<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Patients list">
    <h1>Patients</h1>
    <form method="POST" action="${pageContext.request.contextPath}/patients">
        <div class="input-group mb-2">
            <button class="btn btn-info" type="submit">Save to JSON</button>
<%--            <a href="patients100.json" download>Download JSON</a>--%>
        </div>
    </form>
    <p>${requestScope.patientIds.size()} patients</p>
    <div class="list-group">
        <c:forEach var="patient" items="${requestScope.patientIds}">
            <a class="list-group-item list-group-item-action" href="patients/${patient}">${patient}</a>
        </c:forEach>
    </div>
</t:base>