<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Application Details</title>
    <style>
        /* Basic reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: rgb(24, 157, 255); /* RGB Background */
            background: linear-gradient(45deg, rgb(24, 157, 255), rgb(13, 137, 253)); /* Gradient */
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Slight opacity for the form container */
            border-radius: 10px;
            padding: 30px;
            width: 100%;
            max-width: 500px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
            font-size: 2em;
            font-weight: 600;
        }

        label {
            font-size: 1.1em;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 2px solid #ddd;
            border-radius: 5px;
            font-size: 1em;
        }

        input[type="text"]:focus, input[type="password"]:focus, select:focus {
            outline: none;
            border-color: rgb(24, 157, 255); /* Focus effect */
        }

        input[type="submit"] {
            background-color: rgb(24, 157, 255);
            color: white;
            border: none;
            padding: 15px;
            font-size: 1.1em;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: rgb(13, 137, 253); /* Hover effect */
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .container {
                padding: 25px;
                width: 90%;
            }

            h1 {
                font-size: 1.8em;
            }

            label {
                font-size: 1em;
            }

            input[type="text"], input[type="password"], select {
                font-size: 1em;
            }

            input[type="submit"] {
                padding: 12px;
                font-size: 1em;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Loan Application Form</h1>

        <!-- Create a form to input customer details -->
        <form action="loanDetails.jsp" method="POST">
            <label for="cust_Id">Customer ID:</label>
            <input type="text" id="cust_Id" name="cust_Id" required><br><br>

            <label for="accno">Account Number:</label>
            <input type="text" id="accno" name="accno" required><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>

            <label for="loanType">Loan Type:</label>
            <select id="loanType" name="loanType" required>
                <option value="personal">Personal</option>
                <option value="home">Home</option>
                <option value="car">Car</option>
            </select><br><br>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
