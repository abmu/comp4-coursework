<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Add patient">
    <h1>Add</h1>
    <div id="form">
        <form method="post" action="/add">
            <fieldset>
                <c:forEach var="columnName" items="${columnNames}">
                    <div class="form-group mb-2">
                        <label for="${columnName}">${columnName}</label>
                        <input class="form-control w-25" type="text" name="patientdata" id="${columnName}" ${columnName == 'ID' ? 'required="true"' : ''}/>
                    </div>
                </c:forEach>
                <div class="form-group mt-3">
                    <button class="btn btn-success btn-icon" type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
                            <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
                        </svg>
                        Add
                    </button>
                    <a class="btn btn-secondary" href="/patients">Cancel</a>
                </div>
            </fieldset>
        </form>
    </div>
</t:base>