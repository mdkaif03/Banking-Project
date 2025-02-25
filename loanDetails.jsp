<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Loan Application Submitted</title>
</head>
<body>
    <h1>Loan Application Submitted</h1>

    <%
        // Retrieving customer details and loan type from the request
        String customerId = request.getParameter("cust_Id");
        String accNo = request.getParameter("accno");
        String password = request.getParameter("password"); // Remember, this should be kept secure and not displayed
        String loanType = request.getParameter("loanType");

        // For demonstration, just printing the values
        out.println("<p>Customer ID: " + customerId + "</p>");
        out.println("<p>Account Number: " + accNo + "</p>");
        out.println("<p>Loan Type: " + loanType + "</p>");
        // Do not display password for security purposes
    %>

</body>
</html>
