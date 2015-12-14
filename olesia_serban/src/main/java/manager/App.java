package manager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("My Manager");
		stage.setScene(scene());
		stage.show();
	}

	public Scene scene() {
		//texts
		Text headline = new Text("Orders");
		headline.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//labels
		Label labelNumOfOrder = new Label("Order no.");

		Label labelManager = new Label("Manger");

		Label labelClient = new Label("Client");

		Label labelOrderDate = new Label("Order Date");

		Label labelTargetDate = new Label("Target date of Production");

		Label labelStatuts = new Label("Status");
		
		Label labelTotalAmount = new Label("Total amount");
		
		Label labelSumForPay = new Label("Total sum for payment");
		
				
		
		//text fields
		TextField numOfOrderField = new TextField();
		numOfOrderField.setEditable(true);

		TextField mangerField = new TextField();
		mangerField.setEditable(true);

		TextField clientField = new TextField();
		clientField.setEditable(true);

		TextField orderDateField = new TextField();
		orderDateField.setEditable(true);

		TextField targetDateField = new TextField();
		targetDateField.setEditable(true);

		TextField statusField = new TextField();
		statusField.setEditable(false);
		statusField.setMouseTransparent(true);
		
		TextField totalAmField = new TextField();
		totalAmField.setEditable(false);
		totalAmField.setMouseTransparent(true);
		
		TextField sumForPayField = new TextField();
		sumForPayField.setEditable(false);
		sumForPayField.setMouseTransparent(true);
		
		//buttons 
		Button helpBtn = new Button("F1 - help");
		Button saveBtn = new Button("F2 - save order");
		Button editBtn = new Button("F4 - edit");
		Button addNewItemBtn = new Button("F7 - add new item");
		Button deleteItemBtn = new Button("F8 - delete item");
		Button exitBtn = new Button("F10 - exit");
		Button importBtn = new Button("F11 - import order");
		Button exportBtn = new Button("F12 - export order");

		//create grid for data input 
		GridPane generalGrid = new GridPane();
		generalGrid.setPadding(new Insets(10,10,10,10));
		generalGrid.setAlignment(Pos.TOP_LEFT);
		generalGrid.setVgap(5);
		generalGrid.setHgap(5);
		
		
		//add children
		generalGrid.add(headline, 5, 0);
		generalGrid.add(labelNumOfOrder, 0, 1);
		generalGrid.add(numOfOrderField, 1, 1);
		generalGrid.add(labelManager, 0, 2);
		generalGrid.add(mangerField, 1, 2);
		generalGrid.add(labelClient, 0, 3);
		generalGrid.add(clientField, 1, 3);
		generalGrid.add(labelOrderDate, 0, 4);
		generalGrid.add(orderDateField, 1, 4);
		generalGrid.add(labelTargetDate, 0, 5);
		generalGrid.add(targetDateField, 1, 5);
		generalGrid.add(labelStatuts, 0, 6);
		generalGrid.add(statusField, 1, 6);
		generalGrid.add(labelTotalAmount, 0, 8);
		generalGrid.add(totalAmField, 1, 8);
		generalGrid.add(labelSumForPay, 0, 9);
		generalGrid.add(sumForPayField, 1, 9);
		
		//Hbox for buttons
		HBox buttonBox = new HBox();
		buttonBox.setLayoutX(15);
		buttonBox.setLayoutY(650);
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		
		buttonBox.getChildren().add(helpBtn);
		buttonBox.getChildren().add(saveBtn);
		buttonBox.getChildren().add(editBtn);
		buttonBox.getChildren().add(addNewItemBtn);
		buttonBox.getChildren().add(deleteItemBtn);
		buttonBox.getChildren().add(exitBtn);
		buttonBox.getChildren().add(importBtn);
		buttonBox.getChildren().add(exportBtn);
		
		//create Group
		Group root = new Group();
		
		root.getChildren().add(generalGrid);
		root.getChildren().add(buttonBox);
		//scene
		Scene scene = new Scene(root, 750, 700);
		return scene;
	}
}
