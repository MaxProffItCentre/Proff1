package action05;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//
public class JavaFxExample3 extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Java Fx Example 3");
		stage.setScene(createScene());
		stage.show();
	}

	public Scene createScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//
		Button btn1 = new Button("Button 1");
		Button btn2 = new Button("Button 2");
		//
		class MyEvent<T> implements EventHandler {
			String name;

			public void handle(Event arg0) {
				System.out.println(name);
			}

			public MyEvent(String n) {
				name = n;
			}
		}
		btn1.setOnAction(new MyEvent<ActionEvent>("1"));
		btn2.setOnAction(new MyEvent<ActionEvent>("2"));

		//
		grid.add(btn1, 0, 0);
		grid.add(btn2, 1, 0);
		//
		Scene scene = new Scene(grid, 600, 400);
		return scene;
	}
}
