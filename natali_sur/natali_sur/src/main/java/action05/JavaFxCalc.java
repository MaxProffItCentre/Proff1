package action05;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*Задача4: Калькулятор:
TextField ( number1)
TextField ( operation)
TextField ( number2)
Button ( =)
TextField ( result)*/
public class JavaFxCalc extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		stage.setScene(createScene());
		stage.show();
	}

	private Scene createScene() {
		Group root = new Group();

		TextField number1 = new TextField("number1");
		number1.setLayoutX(50);
		number1.setLayoutY(80);
		number1.setMinWidth(80);

		TextField operation = new TextField("operation");
		operation.setLayoutX(225);
		operation.setLayoutY(80);
		operation.setMinWidth(80);
		
		TextField number2 = new TextField("number2");
		number2.setLayoutX(400);
		number2.setLayoutY(80);
		number2.setMinWidth(80);
		
		Button button1 = new Button("=");
		button1.setLayoutX(290);
		button1.setLayoutY(120);
		
		TextField result = new TextField("result");
		result.setLayoutX(100);
		result.setLayoutY(160);
		result.setMinWidth(400);
		
		root.getChildren().add(number1);
		root.getChildren().add(operation);
		root.getChildren().add(number2);
		root.getChildren().add(button1);
		root.getChildren().add(result);

		Scene scene = new Scene(root, 600, 400);
		return scene;
	}

}
