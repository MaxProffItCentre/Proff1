package action05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFxExample extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Первое приложение");
		stage.setScene(createScene());
		stage.show();
	}
	public Scene createScene(){
		GridPane gp = new GridPane();
		TextField number1 = new TextField("number1");
		TextField operation = new TextField("operation");
		TextField number2 = new TextField("number2");
		gp.add(number1, 0, 0);
		gp.add(number2, 1, 0);
		gp.add(operation, 2, 0);
		Button but = new Button("=");
		but.setMinWidth(20);
		but.setMinHeight(20);
		gp.add(but, 3, 0);
		TextField result = new TextField("result");
		gp.add(result, 4, 0);
		
		Scene scene = new Scene(gp, 600, 400);
		
		return scene;
	}
}