package com.nehal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class HelloWorldServlet extends  HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Set the content type of the response
	        response.setContentType("text/html");

	        // Get the PrintWriter object to send response to the client
	        PrintWriter out = response.getWriter();

	        // HTML form to accept user's name
	        out.println("<html><body>");
	        out.println("<h2>Welcome! Please enter your name:</h2>");
	        out.println("<form method='POST' action='/GreetingServlet'>");
	        out.println("Name: <input type='text' name='username' />");
	        out.println("<input type='submit' value='Submit' />");
	        out.println("</form>");
	        out.println("</body></html>");
	    }

	    // Handle POST request when form is submitted
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve user input from the form
	        String username = request.getParameter("username");

	        // Set the content type of the response
	        response.setContentType("text/html");

	        // Get the PrintWriter object to send response to the client
	        PrintWriter out = response.getWriter();

	        // Display the personalized greeting
	        out.println("<html><body>");
	        if (username != null && !username.trim().isEmpty()) {
	            out.println("<h1>Hello, " + username + "!</h1>");
	        } else {
	            out.println("<h1>Hi, Stranger!</h1>");
	        }
	        out.println("<br><a href='/GreetingServlet'>Back</a>");
	        out.println("</body></html>");
	    }
}
