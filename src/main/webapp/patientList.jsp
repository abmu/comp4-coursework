<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Patients list">
    <h1>Patients</h1>
    <form method="POST" action="/patients">
        <div class="input-group mb-2">
            <button class="btn btn-info" type="submit">Save to JSON</button>
<%--            <a href="patients100.json" download>Download JSON</a>--%>
        </div>
    </form>
    <p>${patientIds.size()} patients</p>
    <div class="list-group">
        <c:forEach var="patientId" items="${patientIds}">
            <a class="list-group-item list-group-item-action" href="/patients/${patientId}">${patientId}</a>
        </c:forEach>
    </div>
</t:base>