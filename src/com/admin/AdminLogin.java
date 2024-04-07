package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.eCommerce.Common;
import com.eCommerce.EncapsulatedClass;

public class AdminLogin {
	
	public void adminLogin() {
		Scanner sc = new Scanner(System.in);
		Connection conn = Common.getConn();
		EncapsulatedClass ec = new EncapsulatedClass();
		int number = 0;
		while(true) {
			try {
				System.out.println("Login using \n"
				         + "1. emailId  \n"
				         + "2. username \n");
				number = sc.nextInt();
				String emailId ="";
				String password = "";
				String tempPass ="";
				if(number == 1) {
					while(true) {
						try {
							System.out.println("Enter your Email-id :");
							emailId = sc.next();
							String query = "Select * from adminLogin where emailId = ?";
							PreparedStatement ps = conn.prepareStatement(query);
							ps.setString(1, emailId);
							ResultSet rs = ps.executeQuery();
							while(rs.next()) {
								tempPass =rs.getString(4);
								System.out.println(tempPass);
							}
							
									System.out.println("Enter Password ");
									password = sc.next();
									if(password.equals(tempPass)) {
										System.out.println("You have logged in Successfully..!");
										
										break;
									}
									else {
										System.out.println("Username or password is incoreect");
										
									}
								
							
						    
						}catch(InputMismatchException e) {
							System.out.println("Expcting String type data ");
							sc.next();	
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
			}catch(InputMismatchException e) {
				System.out.println("Expcting int type data ");
				sc.next();
			}
			while(true) {
				
				System.out.println("Do you want to try to loggin again ?");
				System.out.println("Enter yes or no");
				String s = sc.next();
				if(s.equalsIgnoreCase("yes")) {
					
				}
				else if(s.equalsIgnoreCase("no")) {
					System.out.println("Thank you");
					break;
				}
			
		}
		}	
	}

	

}
