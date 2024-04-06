package edu.neu.rateSki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import edu.neu.application.mainPageController;
import edu.neu.dataStore.ArrayBag;
import edu.neu.dataStore.rateData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class rateResultControllers implements Initializable{

    @FXML
    private Pane BotPane;

    @FXML
    private TableColumn<rateData, String> ContentColumn;

    @FXML
    private Tab ForumTab;

    @FXML
    private TableColumn<rateData, Double> RateColumn;

    @FXML
    private Pane SearchPane;

    @FXML
    private TableColumn<rateData, String> TimeColumn;

    @FXML
    private TableColumn<rateData, String> ResortColumn;

    @FXML
    private TableColumn<rateData, String> UserColumn;

    @FXML
    private Button btnRate;

    @FXML
    private Button btnSortRate;

    @FXML
    private Button btnSortTime;

    @FXML
    private TableView<rateData> tblResult;
    
    public String username, userPassword;
    private static rateResultControllers instance;
    ArrayBag<String> rateDataBag = new ArrayBag<String>();

    @FXML
    void rateClick(ActionEvent event) {
    	Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/edu/neu/rateSki/rateSkiPage.fxml"));
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
    void sortRateClick(ActionEvent event) {

    }

    @FXML
    void sortTimeClick(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		getUsername(mainPageController.getInstance().getUsername(),mainPageController.getInstance().getPassword());
		
//		UserColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("name"));
//		TimeColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("time"));
//		ResortColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("resort"));
//		RateColumn.setCellValueFactory(new PropertyValueFactory<rateData,Double>("rate"));
//		ContentColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("content"));
		
	}

	public void getUsername(String username, String password) {
		this.username = username;
		this.userPassword = password;
	}
	
	public rateResultControllers() {
		instance = this;
	}
	
	public static rateResultControllers getInstance() {
		return instance;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.userPassword;
	}
}
