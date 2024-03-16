package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private Map<String, String> searchFields = new LinkedHashMap<>() {{
        put("ID", "ID");
        put("FIRST", "First name");
        put("LAST", "Last name");
        put("ADDRESS", "Address");
        put("BIRTHDATE", "Birthdate");
    }};

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("searchFields", searchFields);
        request.setAttribute("selectedField", "ID");

        Model model = ModelFactory.getModel();
        String columnName = request.getParameter("columnname");
        String searchString = request.getParameter("searchstring");

        if (searchString != null && columnName != null) {
            List<Map<String, String>> searchResult = model.searchFor(columnName, searchString);
            request.setAttribute("selectedField", columnName);
            request.setAttribute("searchString", searchString);
            request.setAttribute("result", searchResult);
        }

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
    }
}
