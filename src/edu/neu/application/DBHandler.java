package edu.neu.application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler extends Configs{
	Connection dbconnection;
		
	public Connection getConnection() {
		
		String connectionString = "jdbc:mysql://" + Configs.dbhost + Configs.dbport + "/" + Configs.dbname;
		// jdbc:mysql://localhost:3306/SKIRESORT","root","19991217"
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbconnection = DriverManager.getConnection(connectionString,Configs.dbuser,Configs.dbpass);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return dbconnection;
		
	}
}
