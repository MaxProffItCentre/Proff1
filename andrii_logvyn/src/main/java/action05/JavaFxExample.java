package action05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFxExample extends Application{
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
		GridPane root = new GridPane();
		Button but = new Button("Text");
		Button but1 = new Button("Text1");
		but1.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		        Button btn = (Button)t.getSource();
		        System.out.println(btn.getText());
		    }
		});
		Scene scene = new Scene(root, 300, 500);
		root.add(but, 0, 0);
		root.add(but1, 1, 0);
		return scene;
	}
	
}
