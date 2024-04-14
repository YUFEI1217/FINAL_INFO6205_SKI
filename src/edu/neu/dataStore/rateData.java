package edu.neu.dataStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import edu.neu.application.DBHandler;

public class rateData {
	
	String name, time, resort, content;
	double rate;
	private Connection con;
    private DBHandler handler;
    private PreparedStatement ps;
	
	public rateData() {
		
	}
	
	public rateData(String username, String time, String resort, double rate, String content) {
		this.name = username;
		this.time = time;
		this.resort = resort;
		this.rate = rate;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResort() {
		return resort;
	}

	public void setResort(String resort) {
		this.resort = resort;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void addRateData(String name, String time, String resort, double rate, String content) {
		handler = new DBHandler();
		con = (Connection) handler.getConnection();
		
		
		try {
            ps = con.prepareStatement("INSERT INTO UserRate(Username,Time,SkiResort,Rate,Content) VALUES (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, time);
            ps.setString(3, resort);
            ps.setDouble(4, rate);
            ps.setString(5, content);
            
            if(ps.executeUpdate() > 0){
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Information Dialog");
            	alert.setContentText("You posted!");
            	alert.showAndWait();

            }
            else{
            	System.out.println("No Post");
            }
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
}
