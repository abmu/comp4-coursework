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
import java.util.Map;
import java.util.List;

@WebServlet("/stats")
public class StatisticsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        Patient oldestPatient = model.getOldestPatient();
        request.setAttribute("oldestPatient", oldestPatient);
        Patient youngestPatient = model.getYoungestPatient();
        request.setAttribute("youngestPatient", youngestPatient);
        Patient longestNamePatient = model.getLongestNamePatient();
        request.setAttribute("longestNamePatient", longestNamePatient);
        Map.Entry<String, List<Patient>> mostCommonCity = model.getMostCommonCity();
        request.setAttribute("mostCommonCity", mostCommonCity);
        Map<String, Integer> ageDistribution = model.getAgeDistribution();
        request.setAttribute("ageDistribution", ageDistribution);
        Map<String, Long> genderCount = model.getGenderCount();
        request.setAttribute("genderCount", genderCount);
        Map<String, Long> ethnicityCount = model.getEthnicityCount();
        request.setAttribute("ethnicityCount", ethnicityCount);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/statistics.jsp");
        dispatcher.forward(request, response);
    }
}
