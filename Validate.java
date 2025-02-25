package com.banking.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Validate extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Retrieve the new and confirm password parameters from the form
		String npwd = req.getParameter("npwd");
		String cpwd = req.getParameter("cpwd");

		// Check if passwords match
		if (npwd.equals(cpwd)) {
			// If passwords match, forward the request to ChangePassword
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ChangePassword"); // Servlet to handle the
																								// password change
			requestDispatcher.forward(req, resp); // Forward the request to ChangePassword servlet or logic
		} else {
			// If passwords don't match, redirect to the failure page
			resp.sendRedirect("/BankingProject/ChangePwdFail.html"); // A failure page for incorrect password
																		// confirmation
		}
	}
}
