package com.eCommerce;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.admin.AdminLogin1;

public class RunApplication {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to E-Commerce based Application :");
		System.out.println("Select Logoi Type :-");
		System.out.println("1. User Login \n"
				         + "2. Admin Login \n"
				         + "3. as a Guest ");
		
		int number =0;
		 while(true) {
			 try {
				 System.out.println("Select number from 1 to 3 :");
				 number = sc.nextInt();
				 break;
			 }catch(InputMismatchException e) {
				 System.out.println("Expecting int type data ");
				 sc.next();
			 }
		 }
		 
		 switch(number) {
		 case 1:
			 
			 break;
			 
		 case 2:{
             AdminLogin1 al = new AdminLogin1();
			 al.adminLogin();
		 }
			 break;
			 
		 case 3:
			 
			 break;
			 
		 	 
		 }

	}

}
