package edu.neu.login;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginSetting extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Ski resort");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
