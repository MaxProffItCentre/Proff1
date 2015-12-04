package action06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Task2 extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Classes");
		stage.setScene(createScene());
		stage.show();
		
	}
	public Scene createScene(){
		List<String> classes = getAllClasses(new ArrayList());
		List<String> classes2 = getAllClasses(new HashMap());
		VBox vbox1 = new VBox(50);
		vbox1.setAlignment(Pos.BOTTOM_LEFT);
		for (int i = 0; i < classes.size(); i++) {
			vbox1.getChildren().add(new Button(classes.get(i)));
		}
		VBox vbox2 = new VBox(50);
		vbox2.setAlignment(Pos.BOTTOM_RIGHT);
		for (int i = 0; i < classes2.size(); i++) {
			vbox2.getChildren().add(new Button(classes2.get(i)));
		}
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(100);
		grid.setVgap(20);
		grid.add(vbox1, 0, 0);
		grid.add(vbox2, 1, 0);
		
		Scene scene = new Scene(grid, 600, 600);
		return scene;
		
	}
	public static List<String> getAllClasses(Object o) {
		List<Class> list = new ArrayList<Class>();
		list.add(o.getClass());
		Class objectClass = o.getClass();
		while (objectClass.getSuperclass() != null) {
			list.add(objectClass.getSuperclass());
			objectClass = objectClass.getSuperclass();
		}
		List<String> names= new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			names.add(list.get(i).getName());
		}
		return names;

	}
}
