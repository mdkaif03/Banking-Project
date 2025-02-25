package com.banking.controller;

import java.io.IOException;
import com.banking.model.Model;
import com.banking.utils.customers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

  
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid"); 
        String pwd = req.getParameter("pwd");

        Model m = new Model();

   
        customers c = m.Login(cid, pwd); 

        HttpSession session = req.getSession();

       
        if (c == null) {  
            session.setAttribute("error", "Invalid Customer ID or Password");
            resp.sendRedirect("/BankingProject/LoginFail.html");
        } else {
         
            session.setAttribute("accno", c.getAccno());  
            session.setAttribute("cid", c.getCid());  
            resp.sendRedirect("/BankingProject/Home.html");
        }
    }
}