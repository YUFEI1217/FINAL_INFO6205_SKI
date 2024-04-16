package edu.neu.UserRateMatch;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class ResortInfoController  implements Initializable{

	Alert alert = new Alert(AlertType.INFORMATION);
	
	private String userID;
	BinarySearchTree bst = new BinarySearchTree();
  
    @FXML
    private TextField txt_ResortName;
    
    @FXML
    private TableColumn<Resort, String> col_Introduction;

    @FXML
    private TableColumn<Resort, String> col_Location;

    @FXML
    private TableColumn<Resort, Double> col_Rating;

    @FXML
    private TableColumn<Resort, String> col_ResortName;

    @FXML
    private TableColumn<Resort, String> col_Website;
    
    @FXML
    private TableColumn<Comment, String> col_Comment;
    
    @FXML
    private TableView<Resort> table_UserRateMatch;

    @FXML
    private TableView<Comment> table_Comment;

	ObservableList<Resort> listResort = FXCollections.observableArrayList();
	ObservableList<Resort> listResortForSearch = FXCollections.observableArrayList();
	ObservableList<Comment> listComment = FXCollections.observableArrayList();

	// 02 试试按照我之前的方法连接数据库
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DisplayUserRateMatch();
	}


	public void DisplayUserRateMatch() {
		//userID = MainPageControllers.getInstance().Mainusername();
		
		
		table_UserRateMatch.getItems().clear();// 清空表格
		try {
			/* create jdbc connection */
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/skiresort?zeroDateTimeBehavior=CONVERT_TO_NULL";
			String username = "root";

			String password = "19991217";
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();

			/* get matchliset in these dates */
			

			
			String sqlMatList = "SELECT tb1.SkiResort,tb1.Introduction,tb1.Location,tb1.Website, tb2. avgRating FROM skiresort.resort as tb1 left join (SELECT SkiResort,  round(avg(Rate) ,1) as avgRating FROM skiresort.userrate group by SkiResort) as tb2 on tb1.SkiResort = tb2.SkiResort ;";
			ResultSet resultSet = statement.executeQuery(sqlMatList); // 搭配select使用，其他update什么的都不用

			while (resultSet.next()) {

				listResort.add(new Resort(resultSet.getString("SkiResort"), resultSet.getString("Introduction"), resultSet.getString("Location"), resultSet.getString("Website"), Double.parseDouble(resultSet.getString("avgRating"))));
				bst.insert(resultSet.getString("SkiResort"));
			}
			resultSet.close();// close 搭配select使用，其他update什么的都不用
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("You need to check before search");
			alert.showAndWait();
			return;
		}

		// 不是用来把column和数据库的表对应的,感觉是按照add的位置一一对照的,对应的是Class中的栏位
		col_ResortName.setCellValueFactory(new PropertyValueFactory<Resort, String>("name") );
		col_Introduction.setCellValueFactory(new PropertyValueFactory<Resort, String>("Introduction"));
		col_Location.setCellValueFactory(new PropertyValueFactory<Resort, String>("Location"));
		col_Website.setCellValueFactory(new PropertyValueFactory<Resort, String>("Website"));
		col_Rating.setCellValueFactory(new PropertyValueFactory<Resort, Double>("avgRating"));



		table_UserRateMatch.setItems(listResort);
		
		table_UserRateMatch.setOnMouseClicked(e->{
			if(table_UserRateMatch.getSelectionModel().getSelectedItem() != null) {
				
				table_Comment.getItems().clear();// 清空表格
				try {
					/* create jdbc connection */
					Class.forName("com.mysql.cj.jdbc.Driver");

					String url = "jdbc:mysql://localhost:3306/skiresort?zeroDateTimeBehavior=CONVERT_TO_NULL";
					String username = "root";

					String password = "19991217";
					Connection connection = DriverManager.getConnection(url, username, password);
					Statement statement = connection.createStatement();

					/* get matchliset in these dates */
					

					
					String sqlMatList = "SELECT Content FROM skiresort.userrate WHERE SkiResort = '"+ table_UserRateMatch.getSelectionModel().getSelectedItem().getName() +"' ;";
					ResultSet resultClick = statement.executeQuery(sqlMatList); // 搭配select使用，其他update什么的都不用

					while (resultClick.next()) {

						listComment.add(new Comment(resultClick.getString("Content")));
					}
					resultClick.close();// close 搭配select使用，其他update什么的都不用
					statement.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException ex) {
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("You need to check before search");
					alert.showAndWait();
					return;
				}
				
				
				col_Comment.setCellValueFactory(new PropertyValueFactory<Comment, String>("Comment"));



				table_Comment.setItems(listComment);
			}
		});
		
	
	}


	public void UpdateUserRateMatch() {      	

		table_UserRateMatch.getItems().clear();// 清空表格
		try {
			/* create jdbc connection */
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/skiresort?zeroDateTimeBehavior=CONVERT_TO_NULL";
			String username = "root";

			String password = "19991217";
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();

			/* get matchliset in these dates */
			

			
			String sqlMatList = "SELECT tb1.SkiResort,tb1.Introduction,tb1.Location,tb1.Website, tb2. avgRating FROM skiresort.resort as tb1 left join (SELECT SkiResort,  round(avg(Rate) ,1) as avgRating FROM skiresort.userrate group by SkiResort) as tb2 on tb1.SkiResort = tb2.SkiResort WHERE tb1.SkiResort LIKE'%"+txt_ResortName.getText() +"%';";
			ResultSet resultSet = statement.executeQuery(sqlMatList); // 搭配select使用，其他update什么的都不用

			while (resultSet.next()) {

				listResort.add(new Resort(resultSet.getString("SkiResort"), resultSet.getString("Introduction"), resultSet.getString("Location"), resultSet.getString("Website"), Double.parseDouble(resultSet.getString("avgRating"))));
				
			}
			resultSet.close();// close 搭配select使用，其他update什么的都不用
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("You need to check before search");
			alert.showAndWait();
			return;
		}

		// 不是用来把column和数据库的表对应的,感觉是按照add的位置一一对照的,对应的是Class中的栏位
		col_ResortName.setCellValueFactory(new PropertyValueFactory<Resort, String>("name") );
		col_Introduction.setCellValueFactory(new PropertyValueFactory<Resort, String>("Introduction"));
		col_Location.setCellValueFactory(new PropertyValueFactory<Resort, String>("Location"));
		col_Website.setCellValueFactory(new PropertyValueFactory<Resort, String>("Website"));
		col_Rating.setCellValueFactory(new PropertyValueFactory<Resort, Double>("avgRating"));



		table_UserRateMatch.setItems(listResort);
		
		table_UserRateMatch.setOnMouseClicked(e->{
			if(table_UserRateMatch.getSelectionModel().getSelectedItem() != null) {
				
				table_Comment.getItems().clear();// 清空表格
				try {
					/* create jdbc connection */
					Class.forName("com.mysql.cj.jdbc.Driver");

					String url = "jdbc:mysql://localhost:3306/skiresort?zeroDateTimeBehavior=CONVERT_TO_NULL";
					String username = "root";

					String password = "19991217";
					Connection connection = DriverManager.getConnection(url, username, password);
					Statement statement = connection.createStatement();

					/* get matchliset in these dates */
					

					
					String sqlMatList = "SELECT Content FROM skiresort.userrate WHERE SkiResort = '"+ table_UserRateMatch.getSelectionModel().getSelectedItem().getName() +"' ;";
					ResultSet resultClick = statement.executeQuery(sqlMatList); // 搭配select使用，其他update什么的都不用

					while (resultClick.next()) {

						listComment.add(new Comment(resultClick.getString("Content")));
					}
					resultClick.close();// close 搭配select使用，其他update什么的都不用
					statement.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException ex) {
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("You need to check before search");
					alert.showAndWait();
					return;
				}
				
				
				col_Comment.setCellValueFactory(new PropertyValueFactory<Comment, String>("Comment"));



				table_Comment.setItems(listComment);
			}
		});
	}
}