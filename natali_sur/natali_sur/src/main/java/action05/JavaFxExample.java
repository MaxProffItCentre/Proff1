package action05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxExample extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("First application");
		stage.setScene(createScene());
		stage.show();
	}
	public Scene createScene(){
		return null;
	}
}

