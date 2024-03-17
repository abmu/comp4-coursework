<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Patients list">
    <h1>Patients</h1>
    <form method="POST" action="/patients">
        <div class="input-group mb-2">
            <button class="btn btn-outline-info" type="submit">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                    <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
                    <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708z"/>
                </svg>
                Save to JSON
            </button>
<%--            <a href="data/patients100.json" download>Download JSON</a>--%>
        </div>
    </form>
    <p>${patientIds.size()} patients</p>
    <div class="list-group">
        <c:forEach var="patientId" items="${patientIds}">
            <a class="list-group-item list-group-item-action" href="/patients/${patientId}">${patientId}</a>
        </c:forEach>
    </div>
</t:base>