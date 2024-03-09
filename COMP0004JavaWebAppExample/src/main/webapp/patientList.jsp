<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="/head.jsp"/>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <ul>
    <%
      List<String> patients = (List<String>) request.getAttribute("patientIds");
      for (String patient : patients)
      {
        String href = "dummypage.html";
    %>
    <li><a href="<%=href%>"><%=patient%></a>
    </li>
    <% } %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
