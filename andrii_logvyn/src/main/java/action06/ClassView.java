package action06;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClassView extends Application{
	
	private ArrayList obj1 = new ArrayList();
	private LinkedList obj2 = new LinkedList();
	private Scene scene;
	private GridPane rootPane;
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ierarhi");
		stage.setScene(createScene());
		stage.show();
		
	}
	
	public Scene createScene(){
		
		rootPane = new GridPane();
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setHgap(50);
		rootPane.setVgap(10);
		Button objFname = new Button("ArrayList");
		Button objSname = new Button("LinkedList");
		objFname.setOnAction(new ButtonEvents<ActionEvent>(obj1));
		objSname.setOnAction(new ButtonEvents<ActionEvent>(obj2));
	
		scene = new Scene(rootPane, 600, 600);
		rootPane.add(objFname, 2, 0);
		rootPane.add(objSname, 5, 0);
		return scene;
	}
	
	public class ButtonEvents<T> implements EventHandler{
		private ArrayList<Button> listClasses = new ArrayList<Button>();
		Object obj;
		@Override
		public void handle(Event event) {
			Class<?> cl = obj.getClass().getSuperclass();
			while(cl != null){
				listClasses.add(new Button(cl.getSimpleName()));
				cl = cl.getSuperclass();
			}
			
			for(int i = 0; i < listClasses.size(); i++){
				rootPane.add(listClasses.get(i), rootPane.getColumnIndex((Button)event.getSource()), i+2);
			}
			
		}
		
		public <O> ButtonEvents(O obj){
			this.obj = obj;
		}
		
	}

}
