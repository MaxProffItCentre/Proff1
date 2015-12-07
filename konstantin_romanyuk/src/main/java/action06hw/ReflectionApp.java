package action06hw;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReflectionApp extends Application {
	/*Написать метод, который принимает два объекта любых типов и рисует в графике, иерархию общий классов.
	 (просто прямоугольниками BUTTON)*/
	ArrayList<String> arr=new ArrayList<String>();
	LinkedList<String> list=new 	LinkedList<String>();
	Button button = new Button();
	static GridPane grid = new GridPane();
	static  int indx1;
	static int indx2;
	public static void main(String[] args) {
	
		launch(args);}
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ierarhy");
		primaryStage.setScene(createScene1());
		primaryStage.show();
		
	}
	public Scene createScene1(){
		grid.setAlignment(Pos.CENTER);
		Ierarhy(button,list);
		Scene scene = new Scene(grid, 300, 400);
		return scene;}
	
public static void Ierarhy(Object obj1, Object obj2){
	ArrayList<String> str1=new ArrayList<String>();
	ArrayList<String> str2=new ArrayList<String>();
	ArrayList<String> strR=new ArrayList<String>();

	Class temp1=obj1.getClass();
	while (!(temp1==null))
	{str1.add(temp1.getSimpleName().toString());
	temp1=temp1.getSuperclass();
	};
	Class temp2=obj2.getClass();
	while (!(temp2==null))
	{str2.add(temp2.getSimpleName().toString());
	temp2=temp2.getSuperclass();
	};
	for(int i=0; i<str1.size();i++){
		if (str2.contains(str1.get(i))){
			indx1=i; 
			strR.add(str1.get(i));break;
			}
	
	}
	for(int k=0; k<str2.size();k++){
			if (str1.contains(str2.get(k))){
				indx2=k; 
				if (!strR.contains(str2.get(k))) 
				strR.add(str2.get(k));break;
			}}
	for(int j=0; j<indx1; j++)		{
		grid.add(new Button(str1.get(j)),0,indx1-j+1);
		
	}
	for(int l=0; l<indx2; l++)		{
		grid.add(new Button(str2.get(l)),2,indx2-l+1);
		
	}
	for(int j=indx1; j<str1.size(); j++)		
		grid.add(new Button(str1.get(j)), 1,indx1-j+1 );
	
}
}
