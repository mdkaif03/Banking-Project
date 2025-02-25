package com.banking.model;

import com.banking.utils.customers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet res;

 
    public Model() {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice", "root", "03032003");
    	}
    	catch (Exception e) {
    	    e.printStackTrace();  // Print the full stack trace
    	    System.out.println("Cannot Connect to DB: " + e.getMessage());
    	}// Log the exception message
    	}


 
    public boolean registerCustomer(customers c) {
        try {
         
            String query = "INSERT INTO customers (cname, cid, email, phone, pwd, balance) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, c.getName());  
            pstmt.setString(2, c.getCid());   
            pstmt.setString(3, c.getEmail()); 
            pstmt.setLong(4, c.getPhone());   
            pstmt.setString(5, c.getPwd()); 
            pstmt.setDouble(6, c.getBal());   

         
            int x = pstmt.executeUpdate();
            if(x > 0)
                return true; 
            else
                return false; 
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

  
    public customers Login(String cid, String pwd) {
        customers c = null;
        try {
            String sql = "SELECT accno, cname, email, phone, balance FROM customers WHERE cid = ? AND pwd = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cid);
            pstmt.setString(2, pwd);   
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                c = new customers(); 
                c.setAccno(res.getLong("accno"));
                c.setName(res.getString("cname"));
                c.setEmail(res.getString("email"));
                c.setCid(cid);  // This is already provided as input
                c.setPhone(res.getLong("phone"));
                c.setBal(res.getDouble("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }


    public double getBalance(int accno) {
        try {
            String sql = "SELECT balance FROM customers WHERE accno = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, accno); 
            res = pstmt.executeQuery();
            double balance = 0.0;
            if(res.next()) {
                balance = res.getDouble("balance");
            }
            return balance;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }


    public boolean changePwd(String npwd, int accno) {
        try {
            String sql = "UPDATE customers SET pwd = ? WHERE accno = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, npwd);  
            pstmt.setInt(2, accno);    
            int x = pstmt.executeUpdate();
            return x > 0;  
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
