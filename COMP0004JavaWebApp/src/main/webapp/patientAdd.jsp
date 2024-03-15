<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base>
    <h1>Add</h1>
    <div id="form">
        <form method="post" action="${pageContext.request.contextPath}/add">
            <fieldset>
                <c:forEach var="columnName" items="${requestScope.columnNames}">
                    <div class="form-group mb-2">
                        <label for="${columnName}">${columnName}</label>
                        <input class="form-control w-25" type="text" name="patientdata" id="${columnName}"/>
                    </div>
                </c:forEach>
                <div class="form-group mt-3">
                    <button class="btn btn-primary" type="submit">Add</button>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/patients">Cancel</a>
                </div>
            </fieldset>
        </form>
    </div>
</t:base>