package com.banking.controller;

import java.io.IOException;
import com.banking.model.Model;
import com.banking.utils.customers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
        customers c = new customers();

       
        c.setName(req.getParameter("cname")); 
        c.setCid(req.getParameter("cid")); 
        c.setEmail(req.getParameter("email"));
        String password = req.getParameter("pwd"); 
        
     
        if (password == null || password.isEmpty()) {
            resp.sendRedirect("/BankingProject/RegisterFail.html");
            return;
        }
        
       
        c.setPwd(password);

       
        String balanceStr = req.getParameter("balance");
        if (balanceStr != null && !balanceStr.isEmpty()) {
            try {
                c.setBal(Double.parseDouble(balanceStr)); 
            } catch (NumberFormatException e) {
                
                resp.sendRedirect("/BankingProject/RegisterFail.html");
                return;
            }
        } else {
           
            resp.sendRedirect("/BankingProject/RegisterFail.html");
            return;
        }

       
        String phoneStr = req.getParameter("phone");
        if (phoneStr != null && !phoneStr.isEmpty()) {
            try {
                c.setPhone(Long.parseLong(phoneStr)); 
            } catch (NumberFormatException e) {
            
                resp.sendRedirect("/BankingProject/RegisterFail.html");
                return;
            }
        } else {
            resp.sendRedirect("/BankingProject/RegisterFail.html");
            return;
        }

       
        Model m = new Model();

       
        boolean res = m.registerCustomer(c); 

       
        if (res) {
            resp.sendRedirect("/BankingProject/RegisterSuccess.html"); 
        } else {
            resp.sendRedirect("/BankingProject/RegisterFail.html");
        }
    }
}
