package action06;



import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application {
	public static void main(String[] args) {

		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator Smile");
		stage.setScene(scene());
		stage.show();
	}

	public Scene scene() {
		final Text actiontarget = new Text();
		//text just for Fun Tahoma Tolkien,
		Text scenetitle = new Text("Calculator");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		scenetitle.setFill(Color.CORNFLOWERBLUE);
		
		
		// text field for the first number
		TextField number1 = new TextField();
		number1.setMaxSize(100, 20);
		number1.setEditable(true);
		
		// text field for operation sign
		TextField operation = new TextField();
		operation.setMaxSize(50, 20);
		operation.setEditable(true);

		// text field for the second number
		TextField number2 = new TextField();
		number2.setMaxSize(100, 20);
		number2.setEditable(true);

		// Button for "="
		Button btn = new Button("=");
		btn.setMaxSize(60, 20);
		btn.setTextFill(Color.DARKBLUE);
		

		// text field for result
		TextField result = new TextField();
		result.setMaxSize(150, 20);
		result.setEditable(false);
		result.setMouseTransparent(true);

		// Event for my button
		class MyEvent<T> implements EventHandler {
			
			TextField num1;
			TextField action;
			TextField num2;
			TextField result;

			public MyEvent(TextField num1, TextField action, TextField num2, TextField result) {
				this.num1 = num1;
				this.num2 = num2;
				this.action = action;
				this.result = result;

			}

			public String result(String num1, String num2, String action) {

				if (action.equals("+")) {
					return new Double(num1) + new Double(num2) + "";
				} else if (action.equals("-")) {
					return new Double(num1) - new Double(num2) + "";
				} else if (action.equals("*")) {
					return new Double(num1) * new Double(num2) + "";
				} else if (action.equals("/")) {
					return new Double(num1) / new Double(num2) + "";
				} else {
					return "Invalid operation";
				}


			}

			public void handle(Event event) {
				result.setText(result(num1.getText(), num2.getText(), action.getText()));
				actiontarget.setFill(Color.FIREBRICK);
		        actiontarget.setText("=)");
		        actiontarget.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 20));
				System.out.println("=)");

			}

		}
		// add all elements to grid
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		grid.add(scenetitle, 0, 0);
		grid.add(number1, 0, 1);
		grid.add(operation, 1, 1);
		grid.add(number2, 2, 1);
		grid.add(btn, 3, 1);
		grid.add(result, 4, 1);
		grid.add(actiontarget, 4, 2);
		
		// setting button on action
		btn.setOnAction(new MyEvent(number1, operation, number2, result));

		Scene scene = new Scene(grid, 550, 200);
		
		
		return scene;

	}

}
