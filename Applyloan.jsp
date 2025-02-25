<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Apply for a Loan</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        text-align: center;
        padding: 30px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 8px;
        color: #555;
        font-weight: bold;
    }

    select, button {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    button {
        background-color: #4CAF50;
        color: white;
        font-size: 1em;
        border: none;
        cursor: pointer;
    }

    button:hover {
        background-color: #45a049;
    }

</style>
</head>
<body>
    <div class="container">
        <h1>Apply for a Loan</h1>
        <form action="<%= request.getContextPath() %>/loanApplicationPage.jsp" method="post">
            <button type="submit">Apply Loan</button>

           
            <label for="loanType">Select Loan Type</label>
            <select id="loanType" name="loanType">
                <option value="homeLoan">Home Loan</option>
                <option value="bikeLoan">Bike Loan</option>
                <option value="carLoan">Car Loan</option>
                <option value="personalLoan">Personal Loan</option>
            </select>
        </form>
    </div>
</body>
</html>
