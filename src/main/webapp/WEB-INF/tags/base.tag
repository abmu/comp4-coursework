<%@ tag description="Base Tag" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" type="java.lang.String"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link rel="shortcut icon" type = 'image/x-icon' href="/static/health.svg">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/static/styles.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="/">
                    <img src="/static/health.svg"/>
                    Patient Data App
                </a>
                <ul class="navbar-nav">
                    <li class="nav-item ps-3">
                        <a class="nav-link" href="/patients">Patients list</a>
                    </li>
                    <li class="nav-item ps-3">
                        <a class="nav-link" href="/add">Add</a>
                    </li>
                    <li class="nav-item ps-3">
                        <a class="nav-link" href="/search">Search</a>
                    </li>
                    <li class="nav-item ps-3">
                        <a class="nav-link" href="/stats">Statistics</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="content" class="container mt-3">
            <jsp:doBody/>
        </div>
        <footer id="footer">
            <div>
                <p>2024 Abdul Muhaymin Abdul Hafiz</p>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
