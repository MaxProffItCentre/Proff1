package action06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calc2 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SuperCALC");
		stage.setScene(creatScene());
		stage.show();
	}
	
	public Scene creatScene(){
		GridPane grid1 = new GridPane();
		GridPane grid2=new GridPane();
		TextField chuslo1=new TextField();
		TextField chuslo2=new TextField();
		TextField operation=new TextField();
		TextField rezult=new TextField();
		Button ravno = new Button("=");
		Button clear = new Button("C");
		operation.setMaxWidth(40);
		clear.setMinWidth(512);
		
		grid1.add(chuslo1, 0, 0);
		grid1.add(operation, 1, 0);
		grid1.add(chuslo2, 2, 0);
		grid1.add(ravno, 3,0);
		grid1.add(rezult, 4, 0);
		
		
		grid2.add(clear, 0, 0);
		
		
		grid1.setAlignment(Pos.TOP_CENTER);
		grid1.setPadding(new Insets(50, 50, 0, 50));
		grid2.setAlignment(Pos.TOP_CENTER);
		
		GridPane grid = new GridPane();
		grid.add(grid1,0,0);
		grid.add(grid2, 0, 1);
		
		ravno.setOnAction(new MyEvent<ActionEvent>(chuslo1,chuslo2,operation,rezult,"="));
		clear.setOnAction(new MyEvent<ActionEvent>(chuslo1,chuslo2,operation,rezult,"C"));
		
		Scene scene = new Scene(grid,650,150);
		return scene;
	}
}

class MyEvent<T> implements EventHandler {
	TextField chuslo1;
	TextField chuslo2;
	TextField operation;
	TextField rezult;
	String str;

	public MyEvent(TextField chuslo1, TextField chuslo2, TextField operation, TextField rezult,String str) {
		super();
		this.chuslo1 = chuslo1;
		this.chuslo2 = chuslo2;
		this.operation = operation;
		this.rezult = rezult;
		this.str=str;
	}

	@Override
	public void handle(Event arg0) {
		if(str.equals("=")){
		Double k1=new Double(chuslo1.getText()); 
		Double k2=new Double(chuslo2.getText()); 
		if (operation.getText().equals("+"))rezult.setText(Double.toString(k1+k2));
		if (operation.getText().equals("-")) rezult.setText(Double.toString(k1-k2));
		if (operation.getText().equals("*")) rezult.setText(Double.toString(k1*k2));
		if (operation.getText().equals("/")) rezult.setText(Double.toString(k1/k2));	
	} else if (str.equals("C")){
		chuslo1.setText("");chuslo2.setText("");operation.setText("");rezult.setText("");
	}
	}
}
