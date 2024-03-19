package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/patients/*")
public class PatientServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] pathParts = request.getPathInfo().split("/");
        String patientId = pathParts[1];
        if (pathParts.length > 2) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        Model model = ModelFactory.getModel();
        Patient patientRecord = model.getPatientRecord(patientId);
        request.setAttribute("patientRecord", patientRecord);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/patient.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] pathParts = request.getPathInfo().split("/");
        String patientId = pathParts[1];
        String command = pathParts[2];
        if (pathParts.length > 3 || !(command.equals("edit") || command.equals("delete"))) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        Model model = ModelFactory.getModel();
        String redirect;
        if (command.equals("edit")) {
            List<String> newPatientRecord = new ArrayList<>(Arrays.asList(request.getParameterValues("patientdata")));
            model.updatePatientRecord(patientId, newPatientRecord);
            redirect = "/patients/" + patientId;
        } else {
            model.deletePatientRecord(patientId);
            redirect = "/patients";
        }
        model.writeCsvFile();

        response.sendRedirect(redirect);
    }
}
