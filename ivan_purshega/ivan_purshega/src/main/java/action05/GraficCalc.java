package action05;

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

public class GraficCalc extends Application {
		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage stage) throws Exception {
			stage.setTitle("Cacl");
			stage.setScene(createScene1());
			stage.show();
		}

		public Scene createScene1() {
			
			AbstractProc processor = new Proc();
			Calc calc = new Calc(processor);
			char[] charu = { '9', '8', '7', '-', '6', '5', '4', '*', '3', '2', '1',
					'+', '0', 'C', '=', '/' };
			Button[] buttons = new Button[charu.length];
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(20);
			grid.setVgap(20);
			grid.setMinWidth(130);
			grid.setPadding(new Insets(0, 0, 0, 25));

			for (int i = 0; i < charu.length; i++) {
				buttons[i] = new Button("" + charu[i]);
				buttons[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
			}

			int x = 0;
			int y = 0;
			for (int i = 0; i < charu.length; i++) {
				grid.add(buttons[i], x, y);
				x++;
				if (i + 1 == ((i + 1) / 4) * 4) {
					y++;
					x = 0;
				}
				buttons[i].setMinWidth(50);
			}

			GridPane grid2 = new GridPane();
			grid2.setAlignment(Pos.TOP_LEFT);
			grid2.setHgap(20);
			grid2.setVgap(10);
			grid2.setPadding(new Insets(25, 25, 25, 25));

			GridPane grid3 = new GridPane();
			grid3.setAlignment(Pos.TOP_LEFT);
			grid3.setHgap(20);
			grid3.setVgap(10);
			grid3.setPadding(new Insets(25, 25, 25, 25));

			Button oFoN = new Button("Off/On");
			oFoN.setMinWidth(260);
			 oFoN.setStyle("-fx-background-color:red,Khaki");
			  //hBox.setStyle("-fx-border:1px solid #ed1c24");
			grid3.add(oFoN, 0, 0);

			TextField text;
			text = new TextField();
			text.setText("");
			text.setLayoutX(200);
			text.setLayoutY(80);
			text.setMinWidth(260);
			grid2.add(text, 0, 0);
			
		

			GridPane grid4 = new GridPane();
			grid4.setAlignment(Pos.TOP_LEFT);
			grid4.setHgap(0);
			grid4.setVgap(0);
			grid4.setPadding(new Insets(0, 0, 0, 0));

			grid4.add(grid2, 0, 0);
			grid4.add(grid, 0, 1);
			grid4.add(grid3, 0, 2);

			for (int i = 0; i < charu.length; i++) {
				buttons[i].setOnAction(new MyEvent<ActionEvent>(charu[i], calc,
						text, processor));
			}

			oFoN.setOnAction(new MyEvent<ActionEvent>('m', calc, text, processor));
			
			Scene scene = new Scene(grid4, 600, 400);
			return scene;
		}

		
	}

	class MyEvent<T> implements EventHandler {
		Calc cal;
		char name;
		TextField tex;
		AbstractProc proces;
		int OfOn = 0;

		@Override
		public void handle(Event arg0) {
			if (name == 'm') {
				if (OfOn == 0) {
					OfOn = 1;
					tex.setText("0");
				} else {
					OfOn = 0;
					proces.setResult(0);
					tex.setText("");
				}
			} else { 
				if (tex.getText().equals("")) { } else {
					cal.inSymv(name);
					if (name == 'C') {
						proces.setTemp(0);
						proces.setResult(0);
						tex.setText("0");
					}
					if (name == '+' || name == '-' || name == '/' || name == '*') {
					}

					else {

						tex.setText(proces.getResult2());
					} 
				} 
			}
		}

		public MyEvent(char c, Calc calc, TextField b, AbstractProc pr) {

			name = c;
			cal = calc;
			tex = b;
			proces = pr;

		}

		

	}
