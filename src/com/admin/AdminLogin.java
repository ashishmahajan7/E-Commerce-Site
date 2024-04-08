package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eCommerce.Common;

public class AdminLogin {
	String password;
	String tempPass;
	Scanner sc = new Scanner(System.in);
	Connection conn = Common.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void adminLogin() {
		
		while(true) {
			System.out.println("Enter the emailId or mobile number :");
			String temp= sc.next();
			if(isEmailId(temp)) {
				System.out.println(temp + " is emailId");
				loginUsingEmailId(temp);
			}
			else if(isMobileNumber(temp)) {
				System.out.println(temp + " is mobileNumber");
				loginUsingMobileNumber(temp);
			}
			else {
				System.out.println("Invalid emailId or Mobile Number");
			}
		}
	}
	
	public void loginUsingEmailId(String emailId) {
		String query = "Select aPassword from adminLogin where emailId = ? ";
		 try {
			ps = conn.prepareStatement(query);
			ps.setString(1, emailId);
			rs = ps.executeQuery();
			
			System.out.println("Enter Password ");
			password = sc.next();
			
			while(rs.next()) {
				tempPass =rs.getString(1);
				System.out.println(tempPass);
			}
			if(password.equals(tempPass)) {
				System.out.println("You have logged in Successfully..!");
				
			}
			else {
				System.out.println("Username or password is incoreect\n");
				System.out.println("*********************************\n");
				System.out.println("Do you Want to try to login again");
				System.out.println("Enter yes or no");
				String check = sc.next();
				while(true) {
					if(check.equalsIgnoreCase("yes")) {
						adminLogin();
					}
					else if(check.equalsIgnoreCase("no")) {
						System.out.println("Thank You \n");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginUsingMobileNumber(String mobileNumber) {
		String query = "Select aPassword from adminLogin where mobileNumber = ? ";
		 try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mobileNumber);
			rs = ps.executeQuery();
			
			System.out.println("Enter Password ");
			password = sc.next();
			
			while(rs.next()) {
				tempPass =rs.getString(1);
				System.out.println(tempPass);
			}
			if(password.equals(tempPass)) {
				System.out.println("You have logged in Successfully..!");
				
			}
			else {
				System.out.println("Username or password is incoreect\n");
				System.out.println("*********************************\n");
				System.out.println("Do you Want to try to login again");
				System.out.println("Enter yes or no");
				String check = sc.next();
				while(true) {
					if(check.equalsIgnoreCase("yes")) {
						adminLogin();
					}
					else if(check.equalsIgnoreCase("no")) {
						System.out.println("Thank You \n");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isEmailId(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern p = Pattern.compile(emailRegex);  
        Matcher m = p.matcher(email);
        return m.matches(); 
    }
	
	public boolean isMobileNumber(String email) 
    {                      
        Pattern p = Pattern.compile("^\\d{10}$"); 
        Matcher m = p.matcher(email);
        return m.matches(); 
    }

}
