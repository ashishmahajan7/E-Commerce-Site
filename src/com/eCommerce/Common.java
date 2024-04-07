package com.eCommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Common {
	
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce" , "root" , "root");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}

}
