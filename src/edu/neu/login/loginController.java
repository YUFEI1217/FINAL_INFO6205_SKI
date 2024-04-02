package edu.neu.login;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class loginController {

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Username;

    @FXML
    private Button btnLogin;

    @FXML
    void ClickMe(ActionEvent event){
    	if(getUsername() != "" && getPassword() != "") {
    		Stage primaryStage = new Stage();
    		Pane root;
			try {
				root = FXMLLoader.load(getClass().getResource("/edu/neu/application/mainPage.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    	}
    }
    
    private String getUsername() {
    	return Username.getText();
    }
    
    private String getPassword() {
    	return Password.getText();
    }

}
