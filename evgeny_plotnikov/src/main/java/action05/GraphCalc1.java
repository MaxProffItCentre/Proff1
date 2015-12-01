package action05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GraphCalc1 extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Калькулятор");
		stage.setScene(createScene());
		stage.show();
	}
	
	public Scene createScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));

		TextField number1 = new TextField();
		number1.setLayoutX(20);
		number1.setLayoutY(80);
		number1.setMinWidth(10);
		number1.setEditable(true);
		
		TextField operation = new TextField();
		operation.setLayoutX(20);
		operation.setLayoutY(10);
		operation.setMinWidth(10);
		
		TextField number2 = new TextField();
		number2.setLayoutX(60);
		number2.setLayoutY(80);
		number2.setMinWidth(10);
		number2.setEditable(true);
		
		TextField result = new TextField();
		number2.setLayoutX(60);
		number2.setLayoutY(80);
		number2.setMinWidth(10);
		number2.setEditable(true);
		
		Button btn1 = new Button("=");

		class MyEvent<T> implements EventHandler {
			
			TextField text1;
			TextField text2;
			TextField operation;
			TextField result;
			
			public MyEvent(TextField text1, TextField text2, TextField operation, TextField result) {
				this.text1 = text1;
				this.text2 = text2;
				this.operation = operation;
				this.result = result;
			}
			
			public String res(String first, String second, String oper){
				if(oper.equals("+")){
					return new Integer(first) + new Integer(second) + "";
				}
				if(oper.equals("-")){
					return new Integer(first) - new Integer(second) + "";
				}
				if(oper.equals("*")){
					return new Integer(first) * new Integer(second) + "";
				}
				if(oper.equals("/") && !second.equals("0")){
					return new Integer(first) / new Integer(second) + "";
				} else {
					return "Делить на нуль нельзя";
				}
			}
			
//			@Override
			public void handle(Event arg0) {
				result.setText(res(text1.getText(), text2.getText(), operation.getText()));
			}
		}
		
		grid.add(number1, 2, 3);
		grid.add(number2, 6, 3);
		grid.add(operation, 4, 3);
		grid.add(btn1, 7, 3);
		grid.add(result, 9, 3);
		
		btn1.setOnAction(new MyEvent<ActionEvent>(number1, number2, operation, result));
		
		Scene scene = new Scene(grid, 400, 150);
		return scene;
	}
	
	
}
