package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Contact Form</title>");
        response.getWriter().println("<link rel='stylesheet' type='text/css' href='/TJPAD/css/style.css'>");
        response.getWriter().println("<script src='/TJPAD/js/validation.js'></script>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='form-container'>");
        response.getWriter().println("<div class='form-card'>");
        response.getWriter().println("<h1>Contact Form</h1>");
        response.getWriter().println("<p>Please fill in the form below:</p>");
        response.getWriter().println("<form id='contactForm' class='contact-form'>");

        response.getWriter().println("<label for='username'>Name</label>");
        response.getWriter().println("<input type='text' name='username' id='username' placeholder='Enter your name' required>");
        response.getWriter().println("<span id='username-check' class='check-icon'>&#10003;</span>");

        response.getWriter().println("<label for='email'>Email</label>");
        response.getWriter().println("<input type='email' name='email' id='email' placeholder='Enter your email' required>");
        response.getWriter().println("<span id='email-check' class='check-icon'>&#10003;</span>");

        response.getWriter().println("<label for='message'>Message</label>");
        response.getWriter().println("<textarea name='message' id='message' placeholder='Write your message' required></textarea>");
        response.getWriter().println("<span id='message-check' class='check-icon'>&#10003;</span>");

        response.getWriter().println("<label for='category'>Category</label>");
        response.getWriter().println("<select name='category' id='category' required>");
        response.getWriter().println("<option value='Feedback'>Feedback</option>");
        response.getWriter().println("<option value='Inquiry'>Inquiry</option>");
        response.getWriter().println("<option value='Complaint'>Complaint</option>");
        response.getWriter().println("<option value='Suggestion'>Suggestion</option>");
        response.getWriter().println("</select>");

        response.getWriter().println("<input type='submit' value='Submit'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</div>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
