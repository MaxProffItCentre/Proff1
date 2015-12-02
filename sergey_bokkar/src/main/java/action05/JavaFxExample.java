package action05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFxExample extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start (Stage stage){
	Scene scene = new Scene(new Label("FX"));
	stage.setScene(scene);
	stage.show();
	}
}
