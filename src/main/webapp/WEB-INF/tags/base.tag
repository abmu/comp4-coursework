<%@ tag description="Base Tag" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" type="java.lang.String"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link rel="shortcut icon" type = 'image/x-icon' href="/static/favicon.ico">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/static/styles.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="/">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-activity" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M6 2a.5.5 0 0 1 .47.33L10 12.036l1.53-4.208A.5.5 0 0 1 12 7.5h3.5a.5.5 0 0 1 0 1h-3.15l-1.88 5.17a.5.5 0 0 1-.94 0L6 3.964 4.47 8.171A.5.5 0 0 1 4 8.5H.5a.5.5 0 0 1 0-1h3.15l1.88-5.17A.5.5 0 0 1 6 2"/>
                    </svg>
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
        <div id="content" class="container mt-2">
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
