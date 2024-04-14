package edu.neu.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String args[]) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
	      
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SKIRESORT","root","19991217");
				System.out.println("Connect to database!");
			} catch (Exception ex) {
	          System.out.println(ex.getMessage());
			}
		}
	
}
