package edu.neu.rateSki;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javafx.scene.control.cell.PropertyValueFactory;

import edu.neu.application.DBHandler;
import edu.neu.application.mainPageController;
import edu.neu.dataStore.ArrayBag;
import edu.neu.dataStore.rateData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button btnDefault;

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
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    
    ObservableList<rateData> listview = FXCollections.observableArrayList();

    @FXML
    void BackToDefault(ActionEvent event) {
    	try {
			handler = new DBHandler();
			connection = (Connection) handler.getConnection();
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM UserRate");
			listview.clear();
			while(rs.next()) {
				
				listview.add(new rateData(
						rs.getString("Username"),
						rs.getString("Time"),
						rs.getString("SkiResort"),
						rs.getDouble("Rate"),
						rs.getString("Content")
						));
			}
			tblResult.setItems(listview);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
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
    	
    	
		List<List<Object>> allDataList = new ArrayList<List<Object>>();
    	
    	// Get the data from database, and store the data by the nested list
		// The format like [[Killington, 2022-2-3, 3], [Wachusett, 2022-2-6, 4], [Killington, 2022-2-6, 10], [Snow, 2022-2-4, 9], [Pats peak, 2022-2-10, 4]]
		try {
			handler = new DBHandler();
	    	connection = (Connection) handler.getConnection();
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM UserRate");
			Stack<List<Object>> allDataStack = new Stack<>();
			while(rs.next() ) {
				List<Object> temp_list = new ArrayList<Object>();
				temp_list.add(rs.getString("Username"));
				temp_list.add(rs.getString("Time"));
				temp_list.add(rs.getString("SkiResort"));
				temp_list.add(rs.getDouble("Rate"));
				temp_list.add(rs.getString("Content"));
				allDataStack.push(temp_list);
			}
			listview.clear();
			sortRateStack(allDataStack);
			while(!allDataStack.isEmpty()) {
				listview.add(new rateData(
						(String) allDataStack.peek().get(0),
						(String) allDataStack.peek().get(1),
						(String) allDataStack.peek().get(2),
						(double) allDataStack.peek().get(3),
						(String) allDataStack.peek().get(4)
						));
				allDataStack.pop();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @FXML
    void sortTimeClick(ActionEvent event) {
    	
    	
    	// Get the data from database, and store the data by the nested list
		// The format like [[Killington, 2022-2-3, 3], [Wachusett, 2022-2-6, 4], [Killington, 2022-2-6, 10], [Snow, 2022-2-4, 9], [Pats peak, 2022-2-10, 4]]
		try {
			handler = new DBHandler();
	    	connection = (Connection) handler.getConnection();
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM UserRate");
//			Stack<List<Object>> allDataStack = new Stack<>();
			List<List<Object>> allDataList = new ArrayList<List<Object>>();
			while(rs.next() ) {
				List<Object> temp_list = new ArrayList<Object>();
				temp_list.add(rs.getString("Username"));
				temp_list.add(rs.getString("Time"));
				temp_list.add(rs.getString("SkiResort"));
				temp_list.add(rs.getDouble("Rate"));
				temp_list.add(rs.getString("Content"));
				allDataList.add(temp_list);
			}
			listview.clear();
			sortTimeList(allDataList);
			for(List<Object> innerList: allDataList) {
				listview.add(new rateData(
						(String) innerList.get(0),
						(String) innerList.get(1),
						(String) innerList.get(2),
						(double) innerList.get(3),
						(String) innerList.get(4)
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		getUsername(mainPageController.getInstance().getUsername(),mainPageController.getInstance().getPassword());
		
		UserColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("name"));
		TimeColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("time"));
		ResortColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("resort"));
		RateColumn.setCellValueFactory(new PropertyValueFactory<rateData,Double>("rate"));
		ContentColumn.setCellValueFactory(new PropertyValueFactory<rateData,String>("content"));
		
		try {
			handler = new DBHandler();
			connection = (Connection) handler.getConnection();
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM UserRate");
			
			while(rs.next()) {
				
				listview.add(new rateData(
						rs.getString("Username"),
						rs.getString("Time"),
						rs.getString("SkiResort"),
						rs.getDouble("Rate"),
						rs.getString("Content")
						));
			}
			tblResult.setItems(listview);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	/**
     * Using the stack to represent the nested list data. Add each data to the stack one by one
     * Using the Collections.sort to compare the value
     *
     * @param data A Stack of object values(String and Integer) to be sorted.
     * @return     The sorted stack in descending
     */
	public static void sortRateStack(Stack<List<Object>> stack) {
        // Temporary list to store stack elements
        List<List<Object>> tempList = new ArrayList<>();

        // Pop all elements from the stack and store them in tempList
        while (!stack.isEmpty()) {
            tempList.add(stack.pop());
        }

        // Sort tempList based on the first element of each list
        Collections.sort(tempList, Comparator.comparingDouble(list -> (double)list.get(3)));

        // Push sorted elements back onto the stack
        for (List<Object> list : tempList) {
            stack.push(list);
        }
    }
	
	/**
     * Using the stack to represent the nested list data. Add each data to the stack one by one
     * Using the Collections.sort to compare the value of time
     *
     * @param data A Stack of object values(String and Integer) to be sorted.
	 * @return 
     * @return     The sorted stack in Ascending order
     */
	public static List<List<Object>> sortTimeList(List<List<Object>> nestedList) {
        // Temporary list to store stack elements
//        List<List<Object>> tempList = new ArrayList<>();

        // Pop all elements from the stack and store them in tempList


        // Sort tempList based on the first element of each list
        Collections.sort(nestedList, Comparator.comparing(list -> (String)list.get(1)));
        Collections.reverse(nestedList);

        // Push sorted elements back onto the stack
        return nestedList;
    }
	
}
