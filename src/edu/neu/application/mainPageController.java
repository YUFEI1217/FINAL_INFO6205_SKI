package edu.neu.application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.neu.dataStore.ArrayBag;
import edu.neu.login.loginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainPageController implements Initializable{
	
	@FXML
    private Pane BotPane;

    @FXML
    private Pane MidPane;

    @FXML
    private Pane UpPane;

    @FXML
    private Button btnBar;

    @FXML
    private Button btnIntroduction;

    @FXML
    private Button btnSki;

    @FXML
    private Button btnUser;

    @FXML
    private Label lblWelcome;

    @FXML
    private AnchorPane pane;
    
    public String username, userPassword;
    private static mainPageController instance;
    
    ArrayBag<String> mainUserBag = new ArrayBag<String>();

    @FXML
    void ClickBarchart(ActionEvent event) {

    }

    @FXML
    void ClickIntroduction(ActionEvent event) {
    	
    	Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/edu/neu/introduction/introductionPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle(null);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void ClickSki(ActionEvent event) {
    	Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/edu/neu/rateSki/rateResultPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle(null);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ClickUser(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		getMainUser(loginController.getInstance().getUsername(),loginController.getInstance().getPassword());
		
	}
	
	public void getMainUser(String user_name, String password ) {
		this.username = user_name;
		this.lblWelcome.setText("Welcome <" + user_name + ">");
		this.userPassword = password;
	}
	
	public mainPageController() {
		instance = this;
	}
	
	public static mainPageController getInstance() {
		return instance;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.userPassword;
	}
}
