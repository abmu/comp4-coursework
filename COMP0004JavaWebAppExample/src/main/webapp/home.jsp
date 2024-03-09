<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <nav>
        <ul>
            <li>
                <a href="patients">View the Patient ID List</a>
            </li>
            <li>
                <a href="search.html">Search</a>
            </li>
        </ul>
    </nav>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
