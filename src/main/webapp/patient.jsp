<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base title="Edit patient">
    <h1>Update</h1>
    <div id="form">
        <form method="post" action="/patients/${patientRecord.fields['ID']}/edit">
            <fieldset>
                <c:forEach var="data" items="${patientRecord.fields}">
                    <div class="form-group mb-2">
                        <label for="${data.key}">${data.key}</label>
                        <input class="form-control w-25" type="text" name="patientdata" id="${data.key}" value="${data.value}" ${data.key == 'ID' ? 'readonly' : ''}/>
                    </div>
                </c:forEach>
                <div class="form-group mt-3">
                    <button class="btn btn-primary" type="submit">Save</button>
                    <a class="btn btn-secondary" href="/patients">Cancel</a>
                </div>
            </fieldset>
        </form>
        <form method="post" action="/patients/${patientRecord.fields['ID']}/delete">
            <fieldset>
                <div class="form-group mt-2">
                    <button class="btn btn-danger" type="submit">Delete</button>
                </div>
            </fieldset>
        </form>
    </div>
</t:base>