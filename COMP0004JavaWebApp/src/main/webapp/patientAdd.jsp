<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base>
    <div id="form">
        <form method="post" action="${pageContext.request.contextPath}/add">
            <fieldset>
                <c:forEach var="columnName" items="${requestScope.columnNames}">
                    <div class="form-group">
                        <label for="${columnName}">${columnName}</label>
                        <input type="text" name="patientdata" id="${columnName}"/>
                    </div>
                </c:forEach>
                <div class="form-group">
                    <button type="submit">Add</button>
                </div>
            </fieldset>
        </form>
    </div>
</t:base>