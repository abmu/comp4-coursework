package uk.ac.ucl.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients/*")
public class PatientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getPathInfo());
        ServletContext context = getServletContext();
        System.out.println(context);
        RequestDispatcher dispatcher = context.getRequestDispatcher("servlets/SearchServlet");
        dispatcher.forward(request, response);
    }
}
