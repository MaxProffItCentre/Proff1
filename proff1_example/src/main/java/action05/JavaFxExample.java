package action05;

<<<<<<< HEAD
=======
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
>>>>>>> branch 'master' of https://github.com/MaxProffItCentre/Proff1.git

public class JavaFxExample extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) {
		stage.setTitle("Первое приложение");
		stage.setScene(createScene());
		stage.show();
	}
	public Scene createScene(){
		return null;
	}

}
