package HomeTask;

import action04.MiniCalc;
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

/*Задача3. Написать калькулятор с элементами:
	 - TextField(число 1)
	 - TextField(операция)
	 - TextField(число 2)
	 - Button(знак =)  
	 - TextField(результат*/

public class Calc extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Калькулятор");
		stage.setScene(myScene());
		stage.show();
	}
	
	public Scene myScene () {
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(20);
		gp.setPadding(new Insets(25, 25, 25, 25));
		TextField tf1 = new TextField("Введите число");
		TextField tf2 = new TextField("Введите операцию");
		TextField tf3 = new TextField("Введите число");
		Button bt = new Button("=");
		bt.setStyle("-fx-background-color:#FE9A2E");
		bt.setMaxWidth(200);
		TextField tf4 = new TextField("Результат");
		
		class MyEvent<T> implements EventHandler {
			char [] num1 = new char [20];
			char [] num2 = new char [20];
			char symb;
			String str1;
			String str2;
			
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				MiniCalc mc = new MiniCalc();
				str1 = tf1.getText();
				symb = tf2.getText().charAt(0);
				str2 = tf3.getText();
				
				for (int i = 0; i < str1.length(); i++){
					num1[i] = str1.charAt(i);
				}
				for (int i = 0; i < str2.length(); i++){
					num2[i] = str2.charAt(i);
				}
				
				for (char c : num1) mc.inChar(c);
				mc.inChar(symb);
				for (char c: num2) mc.inChar(c);
				mc.inChar('=');
				tf4.setText(mc.printResult());
				mc.close();
			}
		}
		
	
		bt.setOnAction(new MyEvent<ActionEvent>());
	
		gp.add(tf1, 0, 0);
		gp.add(tf2, 0, 1);
		gp.add(tf3, 0, 2);
		gp.add(bt, 0, 3);
		gp.add(tf4, 0, 4);
		
		Scene scene = new Scene(gp, 600, 400);
		return scene;
	}
}
