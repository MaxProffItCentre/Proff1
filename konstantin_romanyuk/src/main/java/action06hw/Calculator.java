package action06hw;
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
public class Calculator extends Application {
      private String resD="";
      TextField text1;
      TextField text2;
      TextField text3;
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
		grid.setHgap(40);
		grid.setVgap(20);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//
		/*Label label1 = new Label("Comment 1");
		label1.setLayoutX(5);
		label1.setLayoutY(14);*/
		//
		text1 = new TextField("number1");
		text1.setMinWidth(60);
		text2 = new TextField("operation");
		text2.setMinWidth(40);
		text3 = new TextField("number2");
		text3.setMinWidth(60);
		textRes = new TextField("result");
		textRes.setMinWidth(40);
		Button button1 = new Button("=");
		button1.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				textRes.setText("0");
						}});
		/*Button button2 = new Button("123");
		button1.setOnAction(new EventHandler<ActionEvent>(){			
			public void handle(ActionEvent e) {
				text.appendText(button2.getText());
			
			
			}});*/
		//
		//Button b2=new MyButton("1");
		//text.setEditable(false);
		//
		grid.add(text1, 0, 0);
		grid.add(text2, 0, 1);
		grid.add(text3, 0, 2);
		grid.add(button1, 0, 3);
		grid.add(textRes, 0, 4);
	
		//		
		Scene scene = new Scene(grid, 300, 250);
		return scene;
	}

	 /*class MyButton extends Button{
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
      */


/*public class Calc {
	private int result;
	private int temp;
	private char operation='0'; // 0+-
	public String printResult(){
		return result+"";
	}
	public void inChar(String p){
		if(p=='='){
			if(operation=='+') result = temp + result;// !! РїРѕСЃР»РµРґРѕРІР°С‚РµР»СЊРЅРѕСЃС‚СЊ РѕРїРµСЂР°РЅРґРѕРІ
			if(operation=='-') result = temp - result;
			if(operation=='*') result = temp * result;
			if(operation=='/') result = temp / result;
			operation='0';
			temp=0;
		} else if('0'<=p && p<='9'){
			if(operation!='0' && temp==0){
				temp = result;
				result = 0;
			}
				result = result*10 + p-'0';
		} else {
			operation = p;
		}
	}*/
	
}

