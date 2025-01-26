package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondServlet extends HttpServlet {

    private static final List<UserData> userDataList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        String category = request.getParameter("category");

        if (username != null && email != null && message != null && category != null) {
            userDataList.add(new UserData(username, email, message, category));
        }

        response.sendRedirect("second");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Submitted Information</title>");
        response.getWriter().println("<link rel='stylesheet' type='text/css' href='/TJPAD/css/style.css'>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='table-container'>");
        response.getWriter().println("<h1>Submitted Information</h1>");
        response.getWriter().println("<h2>Data Summary</h2>");
        response.getWriter().println("<p>Here is the data you have submitted:</p>");
        response.getWriter().println("<div class='card'>");
        response.getWriter().println("<table class='data-table'>");
        response.getWriter().println("<thead>");
        response.getWriter().println("<tr><th>#</th><th>Name</th><th>Email</th><th>Message</th><th>Category</th></tr>");
        response.getWriter().println("</thead>");
        response.getWriter().println("<tbody>");

        for (int i = 0; i < userDataList.size(); i++) {
            UserData data = userDataList.get(i);
            response.getWriter().println("<tr>");
            response.getWriter().println("<td>" + (i + 1) + "</td>");
            response.getWriter().println("<td>" + data.username() + "</td>");
            response.getWriter().println("<td>" + data.email() + "</td>");
            response.getWriter().println("<td>" + data.message() + "</td>");
            response.getWriter().println("<td>" + data.category() + "</td>");
            response.getWriter().println("</tr>");
        }

        response.getWriter().println("</tbody>");
        response.getWriter().println("</table>");
        response.getWriter().println("<div class='card-footer'>");
        response.getWriter().println("<a href='/TJPAD/first' class='btn'>Fill Another Form</a>");
        response.getWriter().println("</div>");
        response.getWriter().println("</div>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
