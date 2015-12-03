package action06hw;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyCalculatorFX extends Application {
    private String resD="";
       TextField textRes;
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
		grid.setAlignment(Pos.CENTER);
		grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		textRes = new TextField("result");
		textRes.setMinWidth(40);
		Button button1 = new Button("1");
		button1.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				textRes.setText("1");
						}});
		Button button2 = new Button("2");
		button2.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				textRes.setText("2");
						}});
		Button button3 = new Button("3");
		button3.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				textRes.setText("3");
						}});
		Button buttonRes = new Button("=");
		buttonRes.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				textRes.setText("0");
						}});
		
		//
		//Button b2=new MyButton("1");
		//text.setEditable(false);
		//
		grid.add(textRes, 0, 0);
		grid.add(button1, 0, 1);
		grid.add(button2, 0, 2);
		grid.add(button3, 0, 3);
		grid.add(buttonRes, 0, 4);
		grid.add(new MyButton("4"), 1, 1);
		//		
		Scene scene = new Scene(grid, 300, 250);
		return scene;
	}

	 class MyButton extends Button{
		
		
		public MyButton(String txt){
			super(txt);
			this.setOnAction(new MyEvent<ActionEvent>(txt));			
				
	
}
	}
    class MyEvent<T> implements EventHandler<ActionEvent>{
  	 String name;
  	  public void handle(ActionEvent e){
  		  textRes.setText(name);
  	  }
  	  public MyEvent(String txt){
  		  name=txt;
  	  }
    }	 
    



	
}

