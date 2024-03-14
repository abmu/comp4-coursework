<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base>
<%--    <ul>--%>
<%--        <c:forEach var="data" items="${requestScope.patientRecord}">--%>
<%--            <li>${data.key}: ${data.value}</li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>

    <div id="form">
        <form method="post" action="/patients/${requestScope.patientRecord['ID']}">
            <fieldset>
                <c:forEach var="data" items="${requestScope.patientRecord}">
                    <div class="form-group">
                        <label for="${data.key}">${data.key}</label>
                        <input type="text" name="patientdata" id="${data.key}" value="${data.value}"/>
                    </div>
                </c:forEach>
                <div class="form-group">
                    <button type="submit">Save</button>
                </div>
            </fieldset>
        </form>
    </div>
</t:base>