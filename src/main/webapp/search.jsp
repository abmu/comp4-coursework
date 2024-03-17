<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Search">
    <h1>Search</h1>
    <form method="GET" action="/search">
        <div class="input-group mb-2">
            <select class="form-select" name="columnname">
                <c:forEach var="field" items="${searchFields}">
                    <option value="${field.key}" ${field.key == selectedField ? 'selected="Selected"' : ''}>${field.value}</option>
                </c:forEach>
            </select>
            <input class="form-control w-75" type="text" name="searchstring" placeholder="Enter search keyword here" value="${searchString}"/>
            <button class="btn btn-success" type="submit">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                </svg>
            </button>
        </div>
    </form>
    <c:if test="${result != null}">
        <c:choose>
            <c:when test="${result.size() > 0}">
                <p>${result.size()} results found</p>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <c:forEach var="field" items="${searchFields}">
                                <th>${field.value}</th>
                            </c:forEach>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="patientRecord" items="${result}">
                            <tr>
                                <c:forEach var="field" items="${searchFields}">
                                    <td>
                                        <c:choose>
                                            <c:when test="${field.key == 'ID'}">
                                                <a href="/patients/${patientRecord.fields['ID']}">${patientRecord.fields['ID']}</a>
                                            </c:when>
                                            <c:otherwise>
                                                ${patientRecord.fields[field.key]}
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>No results found</p>
            </c:otherwise>
        </c:choose>
    </c:if>
</t:base>