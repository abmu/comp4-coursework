<%@ tag description="Base Tag" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" type="java.lang.String"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css"/>
    </head>
    <body>
        <div id="header">
            <h1>Patient Data App</h1>
        </div>
        <div class="main">
            <jsp:doBody/>
        </div>
        <div id="footer">
            <p>The footer</p>
        </div>
    </body>
</html>
