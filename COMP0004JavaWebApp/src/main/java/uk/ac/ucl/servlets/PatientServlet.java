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
import java.util.Map;

@WebServlet("/patients/*")
public class PatientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] pathParts = request.getPathInfo().split("/");
        String patientId = pathParts[1];

        Model model = ModelFactory.getModel();
        Map<String, String> patientRecord = model.getPatientRecord(patientId);

        request.setAttribute("patientRecord", patientRecord);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/patient.jsp");
        dispatcher.forward(request, response);
    }
}
