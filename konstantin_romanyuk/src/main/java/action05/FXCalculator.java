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
		grid.setGridLinesVisible(true);
		grid.setHgap(40);
		grid.setVgap(40);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//
		Label label1 = new Label("Comment 1");
		label1.setLayoutX(5);
		label1.setLayoutY(14);
		//
		text = new TextField("");
		
		text.setMinWidth(60);
		
		
		Button button1 = new Button("=");
		button1.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				text.appendText(button1.getText());
			
			
			}});
		Button button2 = new Button("123");
		button1.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				text.appendText(button2.getText());
			
			
			}});
		//
		//Button b2=new MyButton("1");
		//text.setEditable(false);
		//
		grid.add(text, 0, 0);
		grid.add(button1, 2, 2);
		grid.add(button2, 1, 1);
		grid.add(new MyButton("2"), 1, 1);
		grid.add(new MyButton("3"), 1,1);
	
		//		
		Scene scene = new Scene(grid, 200, 200);
		return scene;
	}

	 class MyButton extends Button{
		Button bb;
		
		public MyButton(String txt){
			bb= new Button(txt);
			bb.setOnAction(new MyEvent<ActionEvent>(txt));
			bb.minWidth(20);
	
}
	}
      class MyEvent<T> implements EventHandler<ActionEvent>{
    	 String name;
    	  public void handle(ActionEvent e){
    		  text.setText(name);
    	  }
    	  public MyEvent(String txt){
    		  name=txt;
    	  }
      }	 
      
}