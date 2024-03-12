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
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        String columnName = request.getParameter("columnname");
        String searchString = request.getParameter("searchstring");
        List<String> searchResult = model.searchFor(columnName, searchString);

        // SET VALUE OF SEARCH OPTION TO LAST OPTION USED
        // SHOW ALL 4 SEARCHABLE FIELDS IN RESULT ie. ID, FIRST, LAST, ZIP
        // BUG: SELECTING A RECORD WHEN THE SEARCH WAS NOT ON ID CAUSES AN ERROR

        request.setAttribute("columnName", columnName);
        request.setAttribute("searchString", searchString);
        request.setAttribute("result", searchResult);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
    }
}
