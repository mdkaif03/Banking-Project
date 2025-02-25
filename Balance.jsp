<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Balance</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: rgb(240, 248, 255); 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
            width: 100%;
            max-width: 500px; 
            text-align: center;
        }
        h4 {
            font-size: 1.2em;
            color: #333;
        }

        
        @media screen and (max-width: 600px) {
            .container {
                padding: 15px;
            }
            h4 {
                font-size: 1em;
            }
        }

        @media screen and (max-width: 400px) {
            h4 {
                font-size: 0.9em;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h4>
            <%
                Object balance = request.getAttribute("balance");
                if (balance != null) {
                    out.print("Your current balance is: " + balance);
                } else {
                    out.print("Unable to fetch your balance at the moment.");
                }
            %>
        </h4>
    </div>
</body>
</html>
