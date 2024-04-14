package edu.neu.rateSki;

import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import edu.neu.application.DBHandler;
import edu.neu.application.mainPageController;
import edu.neu.dataStore.rateData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class rateSkiControllers implements Initializable{

    @FXML
    private Button btnRate;
    
    private String[] skiResort = {"Wachusett Mountain Ski Area", "Killington Ski Resort", "Pats Peak Ski Area", "Jay Peak Resort", "Mountain Sunapee Resort", "Sunday River Resort", "Nashoba Valley Ski Area", "Stowe Mountain Resort", "Okemo Mountain Resort", "Stratton Mountain"};
	
	private Integer[] rate_number = {0,1,2,3,4,5,6,7,8,9,10};
	
	public String username, userPassword;
	public String chooseSki;
	public int chooseRate;
	public String commentSki;
	public String rateTime;
    private static rateSkiControllers instance;
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @FXML
    private ChoiceBox<Integer> cbRate;

    @FXML
    private ChoiceBox<String> cbSki;

    @FXML
    private TextArea txtContent;
    

    @FXML
    void ClickRate(ActionEvent event) {
    	
    	String insert = "INSERT INTO UserRate(Username, Time, SkiResort, Rate, Content)" + "VALUES (?,?,?,?,?)";
    	connection = handler.getConnection();
    	try {
			pst = connection.prepareStatement(insert);
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	chooseSki = cbSki.getValue();
    	chooseRate = cbRate.getValue();
    	commentSki = txtContent.getText();
    	Date date = new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	rateTime = formatter.format(date);
    	rateData rateTable = new rateData();
    	rateTable.addRateData(this.username, rateTime, chooseSki,  chooseRate, commentSki);
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		getRateUser(rateResultControllers.getInstance().getUsername(),mainPageController.getInstance().getPassword());
		
		handler = new DBHandler();
		cbSki.getItems().addAll(skiResort);
		cbRate.getItems().addAll(rate_number);
		
		
		
	}
    
	public void getRateUser(String user_name, String password) {
		this.username = user_name;
		this.userPassword = password;
	}
	
	public rateSkiControllers() {
		instance = this;
	}
	
	public static rateSkiControllers getInstance() {
		return instance;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.userPassword;
	}

}