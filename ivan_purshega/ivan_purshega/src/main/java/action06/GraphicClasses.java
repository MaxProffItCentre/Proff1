package action06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GraphicClasses extends Application {
	static GridPane grid1=new GridPane();
	public static void main(String[] args)   {
		LinkedList obj1= new LinkedList();
		graphic(obj1); 	   //method that accept Object and write graphic hierarchy of classes 
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Hierarchy classes");
		stage.setScene(createScene1());
		stage.show();
	}
	
	public static <Obj> void graphic(Obj obj){
		grid1.setAlignment(Pos.TOP_LEFT);
		grid1.setHgap(20);
		grid1.setVgap(20);
		grid1.setMinWidth(130);
		grid1.setPadding(new Insets(0, 0, 0, 25));
		Class [] classes = getAllClasses(obj);
		Button[] buttons = new Button[classes.length];
		int x=0;
		int y=0;
		for (int i = classes.length-1; i >= 0; i--) {
			buttons[i] = new Button(classes[i].getSimpleName());
			buttons[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
			grid1.add(buttons[i],x,y);
			y++;
		}
	}
	
	public static  Scene createScene1() {
		Scene scene = new Scene(grid1, 300, 400);
		return scene;
	}
	
	public static Class[] getAllClasses(Object obj){
		List<Class> classes = new ArrayList<Class>();
		classes.add(obj.getClass());
		for(int i=0; i<classes.size();i++){
			Class superCl = classes.get(i).getSuperclass();
			if(superCl!=null)classes.add(superCl);
		}	return classes.toArray(new Class[0]);
	
	}
}

