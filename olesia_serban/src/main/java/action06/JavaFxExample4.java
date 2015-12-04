package action06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxExample4 extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Example of JavaFx");
		primaryStage.setScene(createScene());
		primaryStage.show();
		
	}
	TextField resultat = new TextField("empty");
	
	public Scene createScene(){
		VBox box = new VBox(20);
		box.setAlignment(Pos.CENTER);
		
		final DatePicker datePicker = new DatePicker();
		box.getChildren().add(datePicker);
		
		Button btn = new Button("Convert");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    public void handle(ActionEvent e) {
		        resultat.setText(datePicker.getValue().toString());
		    }
		});
		box.getChildren().add(btn);
		
		box.getChildren().add(resultat);
		
		Scene scene = new Scene(box,400,300);
		return scene;
	}

}
