<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Search">
    <h1>Search</h1>
    <form method="GET" action="${pageContext.request.contextPath}/search">
        <div class="input-group">
            <select class="form-select" name="columnname">
                <c:forEach var="field" items="${requestScope.searchFields}">
                    <option value="${field.key}" ${field.key == requestScope.selectedField ? 'selected="Selected"' : ''}>${field.value}</option>
                </c:forEach>
            </select>
            <input class="form-control w-75" type="text" name="searchstring" placeholder="Enter search keyword here" value="${requestScope.searchString}"/>
            <button class="btn btn-success" type="submit">Search</button>
        </div>
    </form>
    <c:if test="${requestScope.result != null}">
        <c:choose>
            <c:when test="${requestScope.result.size() > 0}">
                <p>${requestScope.result.size()} results found</p>
                <table>
                    <tr>
                        <c:forEach var="field" items="${requestScope.searchFields}">
                            <th>${field.value}</th>
                        </c:forEach>
                    </tr>
                    <c:forEach var="patient" items="${requestScope.result}">
                        <tr>
                            <c:forEach var="field" items="${requestScope.searchFields}">
                                <td>
                                    <c:choose>
                                        <c:when test="${field.key == 'ID'}">
                                            <a href="patients/${patient['ID']}">${patient['ID']}</a>
                                        </c:when>
                                        <c:otherwise>
                                            ${patient[field.key]}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>Nothing found</p>
            </c:otherwise>
        </c:choose>
    </c:if>
</t:base>