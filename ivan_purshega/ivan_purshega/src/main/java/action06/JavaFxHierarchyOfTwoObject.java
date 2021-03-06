package action06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFxHierarchyOfTwoObject extends Application {
	static GridPane grid1=new GridPane();
	public static void main(String[] args) {
		ArrayList obj1=new ArrayList();
		LinkedList obj2=new LinkedList();
		graphic(obj1,obj2);
		launch(args);
	}
	
	public static <Obj> void graphic(Obj obj1, Obj obj2){
		grid1.setAlignment(Pos.TOP_LEFT);
		grid1.setHgap(20);
		grid1.setVgap(20);
		grid1.setMinWidth(130);
		grid1.setPadding(new Insets(0, 0, 0, 25));
		
		Class [] classes = getAllClasses(obj1);
		Class [] classes2 = getAllClasses(obj2);
		Button[] buttons = new Button[classes.length];
		Button[] buttons2 = new Button[classes2.length];
		
		System.out.println(classes.length);
		System.out.println(classes2.length);
		
		int x=0;
		int y=0;
		int amount=0;
		if(classes.length>classes2.length) amount=classes.length;
		else amount=classes2.length;
		int i=0;
		for(int j=0; j<amount;j++){
			System.out.println("ff");
			if(buttons.length >i && buttons2.length>i){
			if (classes[i].getSimpleName().equals(classes2[i].getSimpleName())){
				buttons[i] = new Button(classes[i].getSimpleName());
				buttons[i].setMinWidth(200);
				buttons[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
				grid1.add(buttons[i],x+1,y);
			
			} else { if(buttons.length>=i) {buttons[i] = new Button(classes[i].getSimpleName());
					 buttons[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
					 buttons[i].setMinWidth(200);
					 grid1.add(buttons[i],x,y);
					 }
			         if(buttons2.length>=i){
					 buttons2[i] = new Button(classes2[i].getSimpleName());
					 buttons2[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
					 buttons2[i].setMinWidth(200);
					 grid1.add(buttons2[i],x+2,y);
					 }
			         
			}
			} else { if(buttons.length>i) {buttons[i] = new Button(classes[i].getSimpleName());
			 buttons[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
			 buttons[i].setMinWidth(200);
			 grid1.add(buttons[i],x,y);
			 } if(buttons2.length>i){
			 buttons2[i] = new Button(classes2[i].getSimpleName());
			 buttons2[i].setStyle("-fx-background-color:red,green,yellow,blue,white");
			 buttons2[i].setMinWidth(200);
			 grid1.add(buttons2[i],x+2,y);
			 }
				
			} y++;
			i++;
		}
			
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Hierarchy classes");
		stage.setScene(createScene1());
		stage.show();
	}
	
	public static Scene createScene1(){
		return new Scene (grid1, 800,600);
	}
	
	public static Class[] getAllClasses(Object obj){
		List<Class> classes = new ArrayList<Class>();
		classes.add(obj.getClass());
		for(int i=0; i<classes.size();i++){
			Class superCl = classes.get(i).getSuperclass();
			if(superCl!=null)classes.add(superCl);
		}	 List<Class> classes2 = new ArrayList<Class>();
			int size=classes.size();
			for(int i=0; i<classes.size();i++){
				classes2.add(classes.get(size-1));
				size--;
			}
				
		return classes2.toArray(new Class[0]);
	
	}
}
