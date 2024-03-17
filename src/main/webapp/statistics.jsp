<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Statistics">
    <h1>Statistics</h1>
    <p>TODO: gender number (M/F/Other), ethnicity, age distribution</p>
    <div class="mb-4">
        <h4>Oldest patient</h4>
        <p>${oldestPatient.age} years old</p>
        <div class="list-group">
            <a class="list-group-item list-group-item-action" href="/patients/${oldestPatient.fields['ID']}">${oldestPatient.fields['ID']}</a>
        </div>
    </div>
    <div class="mb-4">
        <h4>Youngest patient</h4>
        <p>${youngestPatient.age} years old</p>
        <div class="list-group">
            <a class="list-group-item list-group-item-action" href="/patients/${youngestPatient.fields['ID']}">${youngestPatient.fields['ID']}</a>
        </div>
    </div>
    <div class="mb-4">
        <h4>Longest name</h4>
        <p>${longestNamePatient.name} (${longestNamePatient.nameLength} characters)</p>
        <div class="list-group">
            <a class="list-group-item list-group-item-action" href="/patients/${longestNamePatient.fields['ID']}">${longestNamePatient.fields['ID']}</a>
        </div>
    </div>
    <div class="mb-4">
        <h4>Most common city</h4>
        <p>${mostCommonCity.key} (${mostCommonCity.value.size()} patients)</p>
        <div class="list-group">
            <c:forEach var="patientRecord" items="${mostCommonCity.value}">
                <a class="list-group-item list-group-item-action" href="/patients/${patientRecord.fields['ID']}">${patientRecord.fields['ID']}</a>
            </c:forEach>
        </div>
    </div>
</t:base>