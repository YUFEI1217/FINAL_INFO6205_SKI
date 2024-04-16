package edu.neu.UserRateMatch;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("/edu/neu/MatchManagement/MatchManagement.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("/edu/neu/TeamManagement/TeamManagement.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("/edu/neu/PlayerManagement/PlayerManagement.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("skiResortInfo.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("/edu/neu/PlayerMatchStati/PlayerMatchStati.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}