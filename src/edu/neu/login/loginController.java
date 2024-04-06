package edu.neu.login;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import edu.neu.login.loginController;
import edu.neu.dataStore.ArrayBag;

public class loginController {

	private static loginController instance;
	
    @FXML
    private PasswordField Password;

    @FXML
    private TextField Username;

    @FXML
    private Button btnLogin;

    ArrayBag<String> userBag = new ArrayBag<String>();
    @FXML
    void ClickMe(ActionEvent event){
    	
    	if(getUsername() != "" && getPassword() != "") {
    		userBag.add(getUsername());
    		Stage primaryStage = new Stage();
    		Pane root;
			try {
				root = FXMLLoader.load(getClass().getResource("/edu/neu/application/mainPage.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
//				System.out.println(userBag.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Login Error");
    		alert.setHeaderText("");
    		alert.setContentText("Please input the username and password");
    		alert.showAndWait();
    	}
    }
    
    public loginController() {
		instance = this;
	}

	public static loginController getInstance() {
		return instance;
	}
    
    public String getUsername() {
    	return Username.getText();
    }
    
    public String getPassword() {
    	return Password.getText();
    }
    
    public ArrayBag<String> getArraybag() {
    	return userBag;
    }

}
