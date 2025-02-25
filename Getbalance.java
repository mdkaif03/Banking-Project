package com.banking.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Getbalance")
public class Getbalance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        double balance = 1000.00; 

      
        request.setAttribute("balance", balance);

       
        request.getRequestDispatcher("Balance.jsp").forward(request, response);
    }
}
