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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*Задача4: Калькулятор:
TextField ( number1)
TextField ( operation)
TextField ( number2)
Button ( =)
TextField ( result)*/
public class FXCalculator extends Application {
      private String resD="";
      TextField text;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		stage.setScene(createScene1());
		stage.show();
		
	}
	public Scene createScene1(){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(20);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//
		Label label1 = new Label("Comment 1");
		label1.setLayoutX(5);
		label1.setLayoutY(14);
		//
		text = new TextField("");
		text.setLayoutX(20);
		text.setLayoutY(5);
		text.setMinWidth(80);
		
		
		Button button1 = new Button(" = ");
		button1.setOnAction(new EventHandler(){			
			public void handle(Event arg0) {
				text.appendText(button1.getText());
			
			
			}});
		
		//
		Button b2=new MyButton("1");
		//text.setEditable(false);
		//
		grid.add(text, 0, 0);
		grid.add(button1, 1, 1);
		
		grid.add(b2, 1, 2);
		grid.add(new MyButton("2"), 1, 3);
		grid.add(new MyButton("3"), 1, 4);
		
		//		
		Scene scene = new Scene(grid, 200, 200);
		return scene;
	}

	 class MyButton extends Button{
		Button bb;
		
		public MyButton(String txt){
			bb= new Button(txt);
			bb.setOnAction(new EventHandler(){			
				public void handle(Event arg0) {
					text.appendText(bb.getText());
				}});
			
	
}
	}}